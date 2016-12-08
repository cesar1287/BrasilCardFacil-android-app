package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import br.com.brasilcardfacil.www.brasilcardfacil.R;

public class AccountActivity extends AppCompatActivity {

    private static final String PREF_NAME = "LoginActivityPreferences";
    String id, name, email, profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        id = sp.getString("id", "0");
        name = sp.getString("name","falhou");
        email = sp.getString("email","falhou");
        profilePic = sp.getString("profile_pic","falhou");

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
    }
}
