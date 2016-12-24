package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;

public class PartnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);

        ImageButton btClinicHosp = (ImageButton) findViewById(R.id.partner_med_hosp);
        btClinicHosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnerActivity.this, ClinicHospitalPartnerActivity.class));
            }
        });

        ImageButton btOdonto = (ImageButton) findViewById(R.id.partner_odonto);
        btOdonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnerActivity.this, DentistryPartnerActivity.class));
            }
        });

        ImageButton btVeteri = (ImageButton) findViewById(R.id.partner_veteri);
        btVeteri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnerActivity.this, VeterinaryPartnerActivity.class));
            }
        });

        ImageButton btComer = (ImageButton) findViewById(R.id.partner_comercio);
        btComer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnerActivity.this, TradePartnerActivity.class));
            }
        });

        ImageButton btLab = (ImageButton) findViewById(R.id.partner_lab);
        btLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnerActivity.this, LaboratoryPartnerActivity.class));
            }
        });

        ImageButton btAdvo = (ImageButton) findViewById(R.id.partner_advocacia);
        btAdvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnerActivity.this, AdvocacyPartnerActivity.class));
            }
        });

        ImageButton btFuneral = (ImageButton) findViewById(R.id.partner_funeraria);
        btFuneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PartnerActivity.this, FuneralPartnerActivity.class));
            }
        });
    }
}
