package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.LinkPlansHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class TotalPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_plan);

        setupListeners();
    }

    public void setupListeners(){

        ImageButton btBuy = (ImageButton) findViewById(R.id.total_plan_button_buy);
        btBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diamond_plan = new Intent(TotalPlanActivity.this, WebViewPlansActivity.class);
                diamond_plan.putExtra(Utility.KEY_CONTENT_EXTRA_PLANS, LinkPlansHelper.total_plan);
                startActivity(diamond_plan);
            }
        });
    }
}
