package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerEducationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_education);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btSchool = (ImageButton) findViewById(R.id.education_school);
        btSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEducationActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.EDUCATION);
                intent.putExtra(Utility.SUBCATEGORY, Utility.EDUCATION_SUBCATEGORY_SCHOOL);
                startActivity(intent);
            }
        });

        ImageButton btCourse = (ImageButton) findViewById(R.id.education_course);
        btCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEducationActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.EDUCATION);
                intent.putExtra(Utility.SUBCATEGORY, Utility.EDUCATION_SUBCATEGORY_COURSE);
                startActivity(intent);
            }
        });

        ImageButton btTechnician = (ImageButton) findViewById(R.id.education_technician);
        btTechnician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEducationActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.EDUCATION);
                intent.putExtra(Utility.SUBCATEGORY, Utility.EDUCATION_SUBCATEGORY_TECHNICIAN);
                startActivity(intent);
            }
        });

        ImageButton btUniversity = (ImageButton) findViewById(R.id.education_university);
        btUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEducationActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.EDUCATION);
                intent.putExtra(Utility.SUBCATEGORY, Utility.EDUCATION_SUBCATEGORY_UNIVERSITY);
                startActivity(intent);
            }
        });
    }
}