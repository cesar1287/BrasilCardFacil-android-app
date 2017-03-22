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

        ImageButton btFood = (ImageButton) findViewById(R.id.partner_food);
        btFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerFoodActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btArtDegign = (ImageButton) findViewById(R.id.partner_art_design);
        btArtDegign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerArtDesignActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btAuto = (ImageButton) findViewById(R.id.partner_auto);
        btAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerAutoActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btBeauty = (ImageButton) findViewById(R.id.partner_beauty);
        btBeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerBeautyActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btConsulting = (ImageButton) findViewById(R.id.partner_consulting);
        btConsulting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerConsultingActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btEducation = (ImageButton) findViewById(R.id.partner_education);
        btEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerEducationActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btEntertainment = (ImageButton) findViewById(R.id.partner_entertainment);
        btEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerEntertainmentActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btHome = (ImageButton) findViewById(R.id.partner_home);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerHomeActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btWorldAnimal = (ImageButton) findViewById(R.id.partner_world_animal);
        btWorldAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerWorldAnimalActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btTourism = (ImageButton) findViewById(R.id.partner_tourism);
        btTourism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerTourismActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btHealth = (ImageButton) findViewById(R.id.partner_health);
        btHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerHealthActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btTech = (ImageButton) findViewById(R.id.partner_tech);
        btTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerTechActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btSport = (ImageButton) findViewById(R.id.partner_sport);
        btSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerSportActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btClothing = (ImageButton) findViewById(R.id.partner_clothing);
        btClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerClothingActivity.class);
                startActivity(intent);
            }
        });
    }
}
