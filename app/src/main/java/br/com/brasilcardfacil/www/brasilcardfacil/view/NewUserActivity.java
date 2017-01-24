package br.com.brasilcardfacil.www.brasilcardfacil.view;

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
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class NewUserActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private DatabaseReference mDatabase;

    String Uid, name , email, profile_pic = "";

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();

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
                                                Toast.makeText(NewUserActivity.this, R.string.error_password_too_small,
                                                        Toast.LENGTH_LONG).show();
                                                etPass.setText("");
                                                etPass.requestFocus();
                                            }else if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                                Toast.makeText(NewUserActivity.this, R.string.error_invalid_email,
                                                        Toast.LENGTH_SHORT).show();
                                                etEmail.setText("");
                                                etEmail.requestFocus();
                                            }else if(e instanceof FirebaseAuthUserCollisionException){
                                                Toast.makeText(NewUserActivity.this, R.string.error_failed_signin_email_exists,
                                                        Toast.LENGTH_LONG).show();
                                                etEmail.setText("");
                                                etEmail.requestFocus();
                                            }else{
                                                Toast.makeText(NewUserActivity.this, R.string.error_unknown_error,
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnSuccessListener(NewUserActivity.this, new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            Toast.makeText(NewUserActivity.this, R.string.user_created_successfully,
                                                    Toast.LENGTH_SHORT).show();

                                            FirebaseAuth mAuth = FirebaseAuth.getInstance();

                                            FirebaseUser user = mAuth.getCurrentUser();

                                            finishLogin(user);
                                        }
                                    })
                                    .addOnCompleteListener(NewUserActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task){

                                            // If sign in fails, display a message to the user. If sign in succeeds
                                            // the auth state listener will be notified and logic to handle the
                                            // signed in user can be handled in the listener.
                                            if (task.isSuccessful()) {
                                                finish();
                                            }
                                        }
                                    });
                }else{
                    Toast.makeText(NewUserActivity.this, R.string.error_all_fields_required,
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

                        // [START_EXCLUDE]
                        if (user == null) {

                            FirebaseHelper.writeNewUser(mDatabase, Uid, name, email, "", "", "", "", profile_pic);

                            sp = getSharedPreferences(Utility.LOGIN_SHARED_PREF_NAME, MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();

                            editor.putString("id", Uid);
                            editor.putString("name", name);
                            editor.putString("email", email);
                            editor.putString("profile_pic", profile_pic);
                            editor.apply();
                            finish();
                        } else {

                            sp = getSharedPreferences(Utility.LOGIN_SHARED_PREF_NAME, MODE_PRIVATE);
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
                        Toast.makeText(NewUserActivity.this, R.string.error_create_new_account, Toast.LENGTH_LONG).show();
                    }
                });
    }
}
