package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class AccountActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private static final String PREF_NAME = "LoginActivityPreferences";
    String id, name, mEmail, profilePic, mPhone, mBirth, mSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        id = sp.getString("id", "0");
        name = sp.getString("name","falhou");
        mEmail = sp.getString("email","falhou");
        profilePic = sp.getString("profile_pic","falhou");
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

        final EditText email = (EditText) findViewById(R.id.acc_email);
        email.setText(mEmail);

        final EditText phone = (EditText) findViewById(R.id.acc_phone);
        phone.setText(mPhone);

        final EditText born = (EditText) findViewById(R.id.acc_born);
        born.setText(mBirth);

        final EditText sex = (EditText) findViewById(R.id.acc_sex);
        sex.setText(mSex);

        final ImageButton btEmail = (ImageButton) findViewById(R.id.acc_edit1);
        btEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setEnabled(true);
                email.requestFocus();
            }
        });

        ImageButton btPhone = (ImageButton) findViewById(R.id.acc_edit2);
        btPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone.setEnabled(true);
                phone.requestFocus();
            }
        });

        ImageButton btBorn = (ImageButton) findViewById(R.id.acc_edit3);
        btBorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                born.setEnabled(true);
                born.requestFocus();
            }
        });

        ImageButton btSex = (ImageButton) findViewById(R.id.acc_edit4);
        btSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex.setEnabled(true);
                sex.requestFocus();
            }
        });

        ImageButton btSalvar = (ImageButton) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNewUser(user.getUid(), user.getDisplayName(), email.getText().toString(),
                        born.getText().toString(), sex.getText().toString(), phone.getText().toString(), "", profilePic );
            }
        });
    }

    private void writeNewUser(String userId, String name, String email, String birth, String sex, String phone, String plan, String profile_pic) {

        User user = new User(name, email, birth, phone, sex, plan, profile_pic);

        mDatabase.child("users").child(userId).setValue(user);

        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("birth", birth);
        editor.putString("sex", sex);

        editor.apply();
        finish();

        Toast.makeText(this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }
}
