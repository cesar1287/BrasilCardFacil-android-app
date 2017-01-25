package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.brasilcardfacil.www.brasilcardfacil.R;

public class SplashScreenActivity extends AppCompatActivity {

    boolean showed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getExtras() != null) {

            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);

                if (key.equals("type_notification") && value.equals("active health")) {
                    Intent intent = new Intent(this, ActiveHealthDetailsActivity.class);
                    intent.putExtra("db", getIntent().getExtras().getString("db"));
                    intent.putExtra("child", getIntent().getExtras().getString("child"));
                    startActivity(intent);
                    showed = true;
                    finish();
                    break;
                }else if(key.equals("type_notification") && value.equals("partner")){
                    Intent intent = new Intent(this, PartnerDetailsActivity.class);
                    intent.putExtra("db", getIntent().getExtras().getString("db"));
                    intent.putExtra("child", getIntent().getExtras().getString("child"));
                    startActivity(intent);
                    showed = true;
                    finish();
                    break;
                }else if(key.equals("type_notification") && value.equals("offer")){
                    Intent intent = new Intent(this, OfferDetailsActivity.class);
                    intent.putExtra("db", getIntent().getExtras().getString("db"));
                    intent.putExtra("child", getIntent().getExtras().getString("child"));
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
