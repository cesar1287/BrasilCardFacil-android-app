package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerAutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_auto);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btAirConditioning = (ImageButton) findViewById(R.id.auto_air_conditioning);
        btAirConditioning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_AIR_CONDITIONING);
                startActivity(intent);
            }
        });

        ImageButton btAccessories = (ImageButton) findViewById(R.id.auto_accessories);
        btAccessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_ACCESSORIES);
                startActivity(intent);
            }
        });

        ImageButton btCarsForSale = (ImageButton) findViewById(R.id.auto_cars_for_sale);
        btCarsForSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_CARS_FOR_SALE);
                startActivity(intent);
            }
        });

        ImageButton btResale = (ImageButton) findViewById(R.id.auto_resale);
        btResale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_RESALE);
                startActivity(intent);
            }
        });

        ImageButton btDrivingSchool = (ImageButton) findViewById(R.id.auto_driving_school);
        btDrivingSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_DRIVING_SCHOOL);
                startActivity(intent);
            }
        });

        ImageButton btAutoParts = (ImageButton) findViewById(R.id.auto_auto_parts);
        btAutoParts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_AUTO_PARTS);
                startActivity(intent);
            }
        });

        ImageButton btBatterie = (ImageButton) findViewById(R.id.auto_batterie);
        btBatterie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_BATTERIE);
                startActivity(intent);
            }
        });

        ImageButton btFuel = (ImageButton) findViewById(R.id.auto_fuel);
        btFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_FUEL);
                startActivity(intent);
            }
        });

        ImageButton btEscapement = (ImageButton) findViewById(R.id.auto_escapement);
        btEscapement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_ESCAPEMENT);
                startActivity(intent);
            }
        });

        ImageButton btParking = (ImageButton) findViewById(R.id.auto_parking);
        btParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_PARKING);
                startActivity(intent);
            }
        });

        ImageButton btWash = (ImageButton) findViewById(R.id.auto_wash);
        btWash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_WASH);
                startActivity(intent);
            }
        });

        ImageButton btMechanical = (ImageButton) findViewById(R.id.auto_mechanical);
        btMechanical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_MECHANICAL);
                startActivity(intent);
            }
        });

        ImageButton btTire = (ImageButton) findViewById(R.id.auto_tire);
        btTire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerAutoActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.AUTO);
                intent.putExtra(Utility.SUBCATEGORY, Utility.AUTO_SUBCATEGORY_TIRES);
                startActivity(intent);
            }
        });
    }
}
