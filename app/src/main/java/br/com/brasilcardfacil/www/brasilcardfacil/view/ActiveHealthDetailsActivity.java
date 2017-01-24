package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.ActiveHealth;

public class ActiveHealthDetailsActivity extends AppCompatActivity {

    ActiveHealth activeHealth = new ActiveHealth();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_health_details);

        activeHealth = (ActiveHealth) getIntent().getSerializableExtra("active_health");

        setupUI();
    }

    private void setupUI() {

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(activeHealth.getTitle());
        }

        ImageView iv_banner = (ImageView) findViewById(R.id.active_health_details_banner);
        Glide.with(this).load(activeHealth.getUrlBanner()).into(iv_banner);
        TextView tv_title = (TextView) findViewById(R.id.active_health_details_title);
        tv_title.setText(activeHealth.getTitle());
        TextView tv_description = (TextView) findViewById(R.id.active_health_details_description);
        tv_description.setText(activeHealth.getDescription());
    }
}
