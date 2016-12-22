package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.LinkPlansHelper;

public class FuneralPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funeral_plan);

        ImageButton btBuy = (ImageButton) findViewById(R.id.funeral_plan_button_buy);
        btBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(FuneralPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.funeral_plan);
                startActivity(diamond_plan);
            }
        });
    }
}
