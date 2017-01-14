package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.User;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class AccountActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    InputMethodManager imm;

    String id, name, mEmail, profilePic, mPhone, mBirth, mSex;

    EditText email, phone, born, sex;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        setupUI();

        setupListeners();
    }

    public void setupUI(){

        SharedPreferences sp = getSharedPreferences(Utility.LOGIN_SHARED_PREF_NAME, MODE_PRIVATE);
        id = sp.getString("id", "0");
        name = sp.getString("name","Carregando...");
        mEmail = sp.getString("email","Carregando...");
        profilePic = sp.getString("profile_pic","Carregando...");
        mBirth = sp.getString("birth", "");
        mPhone = sp.getString("phone","");
        mSex = sp.getString("sex","");

        final ImageView nav_image = (ImageView) findViewById(R.id.acc_pic_profile);
        Glide.with(this).load(profilePic).asBitmap().into(new BitmapImageViewTarget(nav_image) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                nav_image.setImageDrawable(circularBitmapDrawable);
            }
        });
        TextView nav_nome = (TextView) findViewById(R.id.acc_name);
        nav_nome.setText(name);

        email = (EditText) findViewById(R.id.acc_email);
        email.setText(mEmail);

        phone = (EditText) findViewById(R.id.acc_phone);
        phone.setText(mPhone);

        born = (EditText) findViewById(R.id.acc_born);
        born.setText(mBirth);

        sex = (EditText) findViewById(R.id.acc_sex);
        sex.setText(mSex);
    }

    public void setupListeners(){

        final ImageButton btEmail = (ImageButton) findViewById(R.id.acc_edit1);
        btEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setEnabled(true);
                email.requestFocus();
                email.setSelection(email.getText().length());
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        });

        ImageButton btPhone = (ImageButton) findViewById(R.id.acc_edit2);
        btPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone.setEnabled(true);
                phone.requestFocus();
                phone.setSelection(phone.getText().length());
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        });

        ImageButton btBorn = (ImageButton) findViewById(R.id.acc_edit3);
        btBorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                born.setEnabled(true);
                born.requestFocus();
                born.setSelection(born.getText().length());
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        });

        ImageButton btSex = (ImageButton) findViewById(R.id.acc_edit4);
        btSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex.setEnabled(true);
                sex.requestFocus();
                sex.setSelection(sex.getText().length());
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        });

        ImageButton btSalvar = (ImageButton) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNewUser(user.getUid(), name, email.getText().toString(),
                        born.getText().toString(), sex.getText().toString(), phone.getText().toString(), "", profilePic );
            }
        });
    }

    private void writeNewUser(String userId, String name, String email, String birth, String sex, String phone, String plan, String profile_pic) {

        User user = new User(name, email, birth, phone, sex, plan, profile_pic);

        mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_USERS).child(userId).setValue(user);

        SharedPreferences sp = getSharedPreferences(Utility.LOGIN_SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("birth", birth);
        editor.putString("sex", sex);

        editor.apply();
        finish();

        Toast.makeText(this, R.string.data_saved_sucess, Toast.LENGTH_SHORT).show();
        finish();
    }
}
