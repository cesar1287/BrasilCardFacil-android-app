package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.LinkPlansHelper;

public class DiamondPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_plan);

        ImageButton btBuy = (ImageButton) findViewById(R.id.diamond_plan_button_buy);
        btBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(DiamondPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.diamond_plan);
                startActivity(diamond_plan);
            }
        });
    }
}
