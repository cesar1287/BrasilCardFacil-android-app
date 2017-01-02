package br.com.brasilcardfacil.www.brasilcardfacil.view;

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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
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

public class NewUserActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private DatabaseReference mDatabase;

    public static final String TAG = "NewUserActivity";
    private static final String PREF_NAME = "LoginActivityPreferences";

    String Uid, name , email, profile_pic = "";

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();

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


        final EditText etName = (EditText) findViewById(R.id.editTextName);
        final EditText etEmail = (EditText) findViewById(R.id.editTextEmail);
        final EditText etPass = (EditText) findViewById(R.id.editTextPass);

        ImageButton btCriar = (ImageButton) findViewById(R.id.new_user_criar);
        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Utility.verifyEmptyField(etName.getText().toString(), etEmail.getText().toString(), etPass.getText().toString())) {
                            name = etName.getText().toString();

                            mAuth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPass.getText().toString())
                                    .addOnFailureListener(NewUserActivity.this, new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            if(e instanceof FirebaseAuthWeakPasswordException){
                                                Toast.makeText(NewUserActivity.this, "Sua senha precisa ter pelo menos 6 caracteres, digite novamente.",
                                                        Toast.LENGTH_LONG).show();
                                                etPass.setText("");
                                                etPass.requestFocus();
                                            }else if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                                Toast.makeText(NewUserActivity.this, "Email inválido, digite novamente.",
                                                        Toast.LENGTH_SHORT).show();
                                                etEmail.setText("");
                                                etEmail.requestFocus();
                                            }else if(e instanceof FirebaseAuthUserCollisionException){
                                                Toast.makeText(NewUserActivity.this, "Falha ao entrar\n" +
                                                                "\n" +
                                                                "Esse e-mail já está sendo usado em nosso sistema e dispositivo.\n" +
                                                                "Tente novamente com outro método de login.",
                                                        Toast.LENGTH_LONG).show();
                                                etEmail.setText("");
                                                etEmail.requestFocus();
                                            }else{
                                                Toast.makeText(NewUserActivity.this, "Erro desconhecido, tente novamente e contate o administrador.",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnSuccessListener(NewUserActivity.this, new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            Toast.makeText(NewUserActivity.this, "Usuário criado com sucesso.",
                                                    Toast.LENGTH_SHORT).show();

                                            FirebaseAuth mAuth = FirebaseAuth.getInstance();

                                            FirebaseUser user = mAuth.getCurrentUser();

                                            finishLogin(user);
                                        }
                                    })
                                    .addOnCompleteListener(NewUserActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task){
                                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                            // If sign in fails, display a message to the user. If sign in succeeds
                                            // the auth state listener will be notified and logic to handle the
                                            // signed in user can be handled in the listener.
                                            if (task.isSuccessful()) {
                                                finish();
                                            }
                                        }
                                    });
                }else{
                    Toast.makeText(NewUserActivity.this, "Todos os campos são obrigatórios, tente novamente.",
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

    public void finishLogin(FirebaseUser user){

        Uid = user.getUid();
        email = user.getEmail();

        mDatabase.child("users").child(Uid).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        User user = dataSnapshot.getValue(User.class);

                        // [START_EXCLUDE]
                        if (user == null) {

                            FirebaseHelper.writeNewUser(mDatabase, Uid, name, email, "", "", "", "", profile_pic);

                            sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();

                            editor.putString("id", Uid);
                            editor.putString("name", name);
                            editor.putString("email", email);
                            editor.putString("profile_pic", profile_pic);
                            editor.apply();
                            finish();
                        } else {

                            sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();

                            editor.putString("id", Uid);
                            editor.putString("name", name);
                            editor.putString("email", email);
                            editor.putString("profile_pic", profile_pic);
                            editor.putString("phone", user.phone);
                            editor.putString("birth", user.birth);
                            editor.putString("sex", user.sex);
                            editor.apply();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
    }
}
