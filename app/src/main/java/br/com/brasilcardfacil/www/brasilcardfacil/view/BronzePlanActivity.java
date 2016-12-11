package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.LinkPlansHelper;

public class BronzePlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bronze_plan);

        ImageButton btBronze1 = (ImageButton) findViewById(R.id.bronze_plan_button_buy);

        btBronze1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(BronzePlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.bronze_1_plan);
                startActivity(diamond_plan);
            }
        });

        ImageButton btBronze2 = (ImageButton) findViewById(R.id.bronze_plan_button_buy1);

        btBronze2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(BronzePlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.bronze_2_plan);
                startActivity(diamond_plan);
            }
        });

        ImageButton btBronze3 = (ImageButton) findViewById(R.id.bronze_plan_button_buy2);

        btBronze3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(BronzePlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.bronze_3_plan);
                startActivity(diamond_plan);
            }
        });
    }
}
