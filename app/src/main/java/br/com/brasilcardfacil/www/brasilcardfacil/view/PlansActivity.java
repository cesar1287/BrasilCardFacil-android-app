package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.brasilcardfacil.www.brasilcardfacil.R;

public class PlansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);

        Button btCheers = (Button) findViewById(R.id.plan_cheers);
        btCheers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlansActivity.this, CheersPlanActivity.class));
            }
        });

        Button btTotal = (Button) findViewById(R.id.plan_total);
        btTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlansActivity.this, TotalPlanActivity.class));
            }
        });

        Button btFuneral = (Button) findViewById(R.id.plan_funeral);
        btFuneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlansActivity.this, FuneralPlanActivity.class));
            }
        });
    }
}
