package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_home);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btTools = (ImageButton) findViewById(R.id.home_tools);
        btTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_TOOLS);
                startActivity(intent);
            }
        });


        ImageButton btArchitecture = (ImageButton) findViewById(R.id.home_architecture);
        btArchitecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_ARCHITECTURE);
                startActivity(intent);
            }
        });

        ImageButton btDecoration = (ImageButton) findViewById(R.id.home_decoration);
        btDecoration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_DECORATION);
                startActivity(intent);
            }
        });

        ImageButton btEngineering = (ImageButton) findViewById(R.id.home_engineering);
        btEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_ENGINEERING);
                startActivity(intent);
            }
        });

        ImageButton btHardware = (ImageButton) findViewById(R.id.home_hardware);
        btHardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_HARDWARE);
                startActivity(intent);
            }
        });

        ImageButton btTimber = (ImageButton) findViewById(R.id.home_timber);
        btTimber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_TIMBER);
                startActivity(intent);
            }
        });

        ImageButton btConstructionMaterial = (ImageButton) findViewById(R.id.home_construction_material);
        btConstructionMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_CONSTRUCTION_MATERIAL);
                startActivity(intent);
            }
        });

        ImageButton btFurniture = (ImageButton) findViewById(R.id.home_furniture);
        btFurniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_FURNITURE);
                startActivity(intent);
            }
        });

        ImageButton btProvisionServices = (ImageButton) findViewById(R.id.home_provision_services);
        btProvisionServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_PROVISION_SERVICES);
                startActivity(intent);
            }
        });

        ImageButton btInk = (ImageButton) findViewById(R.id.home_ink);
        btInk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_INK);
                startActivity(intent);
            }
        });

        ImageButton btGlasses = (ImageButton) findViewById(R.id.home_glasses);
        btGlasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerHomeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.HOME);
                intent.putExtra(Utility.SUBCATEGORY, Utility.HOME_SUBCATEGORY_GLASSES);
                startActivity(intent);
            }
        });
    }
}
