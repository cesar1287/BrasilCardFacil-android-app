package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class SignInEmailPassActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private DatabaseReference mDatabase;

    String Uid, email, profile_pic = "";

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_email_pass);

        mAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final EditText etEmail = (EditText) findViewById(R.id.SigneditTextEmail);
        final EditText etPass = (EditText) findViewById(R.id.SigneditTextPass);

        ImageButton btEntrar = (ImageButton) findViewById(R.id.sign_emailpass_entrar);
        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Utility.verifyEmptyField(etEmail.getText().toString(), etPass.getText().toString())){
                    mAuth.signInWithEmailAndPassword(etEmail.getText().toString(), etPass.getText().toString())
                            .addOnFailureListener(SignInEmailPassActivity.this, new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignInEmailPassActivity.this, R.string.error_user_password_incorrect,
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnSuccessListener(SignInEmailPassActivity.this, new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    FirebaseAuth mAuth = FirebaseAuth.getInstance();

                                    FirebaseUser user = mAuth.getCurrentUser();

                                    finishLogin(user);

                                    finish();
                                }
                            })
                            .addOnCompleteListener(SignInEmailPassActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(SignInEmailPassActivity.this, MainActivity.class));
                                        finish();
                                    }
                                }
                            });
                }else{
                    Toast.makeText(SignInEmailPassActivity.this, R.string.error_all_fields_required,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void finishLogin(FirebaseUser user){

        Uid = user.getUid();
        email = user.getEmail();

        mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_USERS).child(Uid).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        User user = dataSnapshot.getValue(User.class);


                        sp = getSharedPreferences(Utility.LOGIN_SHARED_PREF_NAME, MODE_PRIVATE);
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
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }
}
