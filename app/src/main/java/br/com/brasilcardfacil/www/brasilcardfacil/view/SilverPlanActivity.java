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

public class SilverPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silver_plan);

        ImageButton btSilver1 = (ImageButton) findViewById(R.id.silver_plan_button_buy);

        btSilver1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(SilverPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.silver_1_plan);
                startActivity(diamond_plan);
            }
        });

        ImageButton btSilver2 = (ImageButton) findViewById(R.id.silver_plan_button_buy1);

        btSilver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(SilverPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.silver_2_plan);
                startActivity(diamond_plan);
            }
        });

        ImageButton btSilver3 = (ImageButton) findViewById(R.id.silver_plan_button_buy2);

        btSilver3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(SilverPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.silver_3_plan);
                startActivity(diamond_plan);
            }
        });

        ImageButton btSilver4 = (ImageButton) findViewById(R.id.silver_plan_button_buy3);

        btSilver4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(SilverPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.silver_4_plan);
                startActivity(diamond_plan);
            }
        });
    }
}
