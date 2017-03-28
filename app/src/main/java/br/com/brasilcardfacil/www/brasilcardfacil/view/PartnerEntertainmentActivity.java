package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerEntertainmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_entertainment);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btArchitecture = (ImageButton) findViewById(R.id.entertainment_art);
        btArchitecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_ART);
                startActivity(intent);
            }
        });

        ImageButton btDecoration = (ImageButton) findViewById(R.id.entertainment_toy);
        btDecoration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_TOY);
                startActivity(intent);
            }
        });

        ImageButton btEngineering = (ImageButton) findViewById(R.id.entertainment_movie_theater);
        btEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_MOVIE_THEATER);
                startActivity(intent);
            }
        });

        ImageButton btHardware = (ImageButton) findViewById(R.id.entertainment_decoration);
        btHardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_DECORATION);
                startActivity(intent);
            }
        });

        ImageButton btTimber = (ImageButton) findViewById(R.id.entertainment_dj);
        btTimber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_DJ);
                startActivity(intent);
            }
        });

        ImageButton btFurniture = (ImageButton) findViewById(R.id.entertainment_newspaper);
        btFurniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_NEWSPAPER);
                startActivity(intent);
            }
        });

        ImageButton btProvisionServices = (ImageButton) findViewById(R.id.entertainment_park);
        btProvisionServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_PARK);
                startActivity(intent);
            }
        });

        ImageButton btInk = (ImageButton) findViewById(R.id.entertainment_radio);
        btInk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_RADIO);
                startActivity(intent);
            }
        });

        ImageButton btGlasses = (ImageButton) findViewById(R.id.entertainment_party_hall);
        btGlasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_PARTY_HALL);
                startActivity(intent);
            }
        });

        ImageButton btGlasse = (ImageButton) findViewById(R.id.entertainment_sound);
        btGlasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerEntertainmentActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ENTERTAINMENT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ENTERTAINMENT_SUBCATEGORY_SOUND);
                startActivity(intent);
            }
        });
    }
}
