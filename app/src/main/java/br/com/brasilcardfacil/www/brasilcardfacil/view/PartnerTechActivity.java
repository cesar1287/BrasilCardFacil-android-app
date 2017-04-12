package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerTechActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_tech);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btCellphone = (ImageButton) findViewById(R.id.tech_cellphone);
        btCellphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTechActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TECH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TECH_SUBCATEGORY_CELLPHONE);
                startActivity(intent);
            }
        });

        ImageButton btPhotography = (ImageButton) findViewById(R.id.tech_photography);
        btPhotography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTechActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TECH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TECH_SUBCATEGORY_PHOTOGRAPHY);
                startActivity(intent);
            }
        });

        ImageButton btGames = (ImageButton) findViewById(R.id.tech_games);
        btGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTechActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TECH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TECH_SUBCATEGORY_GAMES);
                startActivity(intent);
            }
        });

        ImageButton btComputing = (ImageButton) findViewById(R.id.tech_computing);
        btComputing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTechActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TECH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TECH_SUBCATEGORY_COMPUTING);
                startActivity(intent);
            }
        });

        ImageButton btInternet = (ImageButton) findViewById(R.id.tech_internet);
        btInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTechActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TECH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TECH_SUBCATEGORY_INTERNET);
                startActivity(intent);
            }
        });

        ImageButton btTechnicians = (ImageButton) findViewById(R.id.tech_technicians);
        btTechnicians.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTechActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TECH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TECH_SUBCATEGORY_TECNICIANS);
                startActivity(intent);
            }
        });

        ImageButton btTvVideo = (ImageButton) findViewById(R.id.tech_tv_video);
        btTvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTechActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TECH);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TECH_SUBCATEGORY_TV_VIDEO);
                startActivity(intent);
            }
        });
    }
}
