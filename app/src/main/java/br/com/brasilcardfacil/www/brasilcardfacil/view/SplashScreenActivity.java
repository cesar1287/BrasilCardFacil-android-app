package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class SplashScreenActivity extends AppCompatActivity {

    boolean showed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getExtras() != null) {

            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);

                if (key.equals(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE) && value.equals(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE_ACTIVE_HEALTH)) {
                    Intent intent = new Intent(this, ActiveHealthDetailsActivity.class);
                    intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE, getIntent().getExtras()
                            .getString(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE));
                    intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD, getIntent().getExtras()
                            .getString(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD));
                    startActivity(intent);
                    showed = true;
                    finish();
                    break;
                }else if(key.equals(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE) && value.equals(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE_PARTNER)){
                    Intent intent = new Intent(this, PartnerDetailsActivity.class);
                    intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE, getIntent().getExtras()
                            .getString(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE));
                    intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD, getIntent().getExtras()
                            .getString(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD));
                    startActivity(intent);
                    showed = true;
                    finish();
                    break;
                }else if(key.equals(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE) && value.equals(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE_OFFER)){
                    Intent intent = new Intent(this, OfferDetailsActivity.class);
                    intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE, getIntent().getExtras()
                            .getString(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE));
                    intent.putExtra(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD, getIntent().getExtras()
                            .getString(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD));
                    startActivity(intent);
                    showed = true;
                    finish();
                    break;
                }else if(key.equals(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE) && value.equals(FirebaseHelper.FIREBASE_NOTIFICATION_TYPE_UPDATE)){
                    Intent intent;
                    try {
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + Utility.APP_PACKAGE_NAME));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + Utility.APP_PACKAGE_NAME));
                    }
                    startActivity(intent);
                    showed = true;
                    finish();
                    break;
                }
            }
        }

        if(!showed) {
            setContentView(R.layout.activity_splash_screen);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    finish();
                }
            }, 3000);
        }
    }
}
