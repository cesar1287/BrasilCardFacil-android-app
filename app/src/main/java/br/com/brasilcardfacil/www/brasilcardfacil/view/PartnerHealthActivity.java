package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerHealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_health);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btClinic = (ImageButton) findViewById(R.id.health_clinic);
        btClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_CLINIC);
                startActivity(intent);
            }
        });

        ImageButton btDrugstore = (ImageButton) findViewById(R.id.health_drugstore);
        btDrugstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_DRUGSTORE);
                startActivity(intent);
            }
        });

        ImageButton btExams = (ImageButton) findViewById(R.id.health_exams);
        btExams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_EXAMS);
                startActivity(intent);
            }
        });

        ImageButton btPhysiotherapy = (ImageButton) findViewById(R.id.health_physiotherapy);
        btPhysiotherapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_PHYSIOTHERAPY);
                startActivity(intent);
            }
        });

        ImageButton btHospital = (ImageButton) findViewById(R.id.health_hospital);
        btHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_HOSPITAL);
                startActivity(intent);
            }
        });

        ImageButton btDoctor = (ImageButton) findViewById(R.id.health_doctor);
        btDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_DOCTOR);
                startActivity(intent);
            }
        });

        ImageButton btNutritionist = (ImageButton) findViewById(R.id.health_nutritionist);
        btNutritionist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_NUTRITIONIST);
                startActivity(intent);
            }
        });

        ImageButton btDentistry = (ImageButton) findViewById(R.id.health_dentistry);
        btDentistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_DENTISTRY);
                startActivity(intent);
            }
        });

        ImageButton btPilates = (ImageButton) findViewById(R.id.health_pilates);
        btPilates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_PILATES);
                startActivity(intent);
            }
        });

        ImageButton btPsychology = (ImageButton) findViewById(R.id.health_psychology);
        btPsychology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHealthActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HEALTH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HEALTH_SUBCATEGORY_PSYCHOLOGY);
                startActivity(intent);
            }
        });
    }
}
