package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.User;

public class SignInEmailPassActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public static final String TAG = "SignInEmailPassActivity";
    private static final String PREF_NAME = "LoginActivityPreferences";

    private DatabaseReference mDatabase;

    String Uid, email, profile_pic = "";

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_email_pass);

        mAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        final EditText etEmail = (EditText) findViewById(R.id.SigneditTextEmail);
        final EditText etPass = (EditText) findViewById(R.id.SigneditTextPass);

        ImageButton btEntrar = (ImageButton) findViewById(R.id.sign_emailpass_entrar);
        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verifyEmptyField(etEmail.getText().toString(), etPass.getText().toString())){
                    mAuth.signInWithEmailAndPassword(etEmail.getText().toString(), etPass.getText().toString())
                            .addOnCompleteListener(SignInEmailPassActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Log.w(TAG, "signInWithEmail:failed", task.getException());
                                        Toast.makeText(SignInEmailPassActivity.this, "Usuário e/ou senha incorreto(s).",
                                                Toast.LENGTH_SHORT).show();
                                    }else{
                                        FirebaseAuth mAuth = FirebaseAuth.getInstance();

                                        FirebaseUser user = mAuth.getCurrentUser();

                                        finishLogin(user);

                                        finish();

                                        startActivity(new Intent(SignInEmailPassActivity.this, MainActivity.class));
                                        finish();
                                    }
                                }
                            });
                }else{
                    Toast.makeText(SignInEmailPassActivity.this, "Todos os campos são obrigatórios, tente novamente.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public boolean verifyEmptyField(String email, String pass){

        return (email.isEmpty() || pass.isEmpty());
    }

    public void finishLogin(FirebaseUser user){

        Uid = user.getUid();
        email = user.getEmail();

        mDatabase.child("users").child(Uid).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        User user = dataSnapshot.getValue(User.class);


                        sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();

                        editor.putString("id", Uid);
                        editor.putString("name", user.name);
                        editor.putString("email", email);
                        editor.putString("profile_pic", profile_pic);
                        editor.putString("phone", user.phone);
                        editor.putString("birth", user.birth);
                        editor.putString("sex", user.sex);
                        editor.apply();
                        finish();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
    }
}
