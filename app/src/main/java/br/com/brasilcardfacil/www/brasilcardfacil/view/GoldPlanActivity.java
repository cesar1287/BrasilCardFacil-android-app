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

public class GoldPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_plan);

        ImageButton btGold1 = (ImageButton) findViewById(R.id.gold_plan_button_buy);

        btGold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(GoldPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.gold_1_plan);
                startActivity(diamond_plan);
            }
        });

        ImageButton btGold2 = (ImageButton) findViewById(R.id.gold_plan_button_buy1);
        btGold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(GoldPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra("link", LinkPlansHelper.gold_2_plan);
                startActivity(diamond_plan);
            }
        });
    }
}
