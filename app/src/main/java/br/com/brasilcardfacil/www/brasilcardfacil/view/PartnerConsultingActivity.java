package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerConsultingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_consulting);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btBusiness = (ImageButton) findViewById(R.id.consulting_business);
        btBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerConsultingActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.CONSULTING);
                intent.putExtra(Utility.SUBCATEGORY, Utility.CONSULTING_SUBCATEGORY_BUSINESS);
                startActivity(intent);
            }
        });

        ImageButton btLegal = (ImageButton) findViewById(R.id.consulting_legal);
        btLegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerConsultingActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.CONSULTING);
                intent.putExtra(Utility.SUBCATEGORY, Utility.CONSULTING_SUBCATEGORY_LEGAL);
                startActivity(intent);
            }
        });
    }
}
