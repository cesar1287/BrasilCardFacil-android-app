package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);

        setupListeners();
    }

    public void setupListeners(){

        ImageButton btClinicHosp = (ImageButton) findViewById(R.id.partner_med_hosp);
        btClinicHosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.CLINIC);
                startActivity(intent);
            }
        });

        ImageButton btOdonto = (ImageButton) findViewById(R.id.partner_odonto);
        btOdonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.DENTISTRY);
                startActivity(intent);
            }
        });

        ImageButton btVeteri = (ImageButton) findViewById(R.id.partner_veteri);
        btVeteri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.VETERINARY);
                startActivity(intent);
            }
        });

        ImageButton btComer = (ImageButton) findViewById(R.id.partner_comercio);
        btComer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                startActivity(intent);
            }
        });

        ImageButton btLab = (ImageButton) findViewById(R.id.partner_lab);
        btLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.LABORATORY);
                startActivity(intent);
            }
        });

        ImageButton btAdvo = (ImageButton) findViewById(R.id.partner_advocacia);
        btAdvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ADVOCACY);
                startActivity(intent);
            }
        });

        ImageButton btFuneral = (ImageButton) findViewById(R.id.partner_funeraria);
        btFuneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FUNERAL);
                startActivity(intent);
            }
        });
    }
}
