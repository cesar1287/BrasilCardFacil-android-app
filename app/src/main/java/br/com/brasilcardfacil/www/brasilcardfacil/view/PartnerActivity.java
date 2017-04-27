package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);

        relativeLayout = (RelativeLayout) findViewById(R.id.snackbar_partners);

        setupListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();

        setupSnackBar();
    }

    public void setupSnackBar(){
        Snackbar snackbar = Snackbar
                .make(relativeLayout, "Cadastre-se como Parceiro Comercial!", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("IR", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, WebViewPlansActivity.class);
                intent.putExtra(Utility.KEY_CONTENT_EXTRA_PLANS, Utility.LINK_BE_PARTNER);
                startActivity(intent);
            }
        });
        snackbar.setActionTextColor(this.getResources().getColor(R.color.BrasilCardFacil));

        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        snackbar.show();
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

        ImageButton btFoodIcon = (ImageButton) findViewById(R.id.partner_food_icon);
        btFoodIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btArtDegignIcon = (ImageButton) findViewById(R.id.partner_art_design_icon);
        btArtDegignIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btAutoIcon = (ImageButton) findViewById(R.id.partner_auto_icon);
        btAutoIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btBeautyIcon = (ImageButton) findViewById(R.id.partner_beauty_icon);
        btBeautyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerBeautyActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btTrade = (ImageButton) findViewById(R.id.partner_trade);
        btTrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                startActivity(intent);
            }
        });

        ImageButton btTradeIcon = (ImageButton) findViewById(R.id.partner_trade_icon);
        btTradeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
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

        ImageButton btConsultingIcon = (ImageButton) findViewById(R.id.partner_consulting_icon);
        btConsultingIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btEducationIcon = (ImageButton) findViewById(R.id.partner_education_icon);
        btEducationIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btEntertainmentIcon = (ImageButton) findViewById(R.id.partner_entertainment_icon);
        btEntertainmentIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btHomeIcon = (ImageButton) findViewById(R.id.partner_home_icon);
        btHomeIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btWorldAnimalIcon = (ImageButton) findViewById(R.id.partner_world_animal_icon);
        btWorldAnimalIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btTourismIcon = (ImageButton) findViewById(R.id.partner_tourism_icon);
        btTourismIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btHealthIcon = (ImageButton) findViewById(R.id.partner_health_icon);
        btHealthIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerHealthActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btServices = (ImageButton) findViewById(R.id.partner_services);
        btServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.SERVICES);
                startActivity(intent);
            }
        });

        ImageButton btServicesIcon = (ImageButton) findViewById(R.id.partner_services_icon);
        btServicesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.SERVICES);
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

        ImageButton btTechIcon = (ImageButton) findViewById(R.id.partner_tech_icon);
        btTechIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btSportIcon = (ImageButton) findViewById(R.id.partner_sport_icon);
        btSportIcon.setOnClickListener(new View.OnClickListener() {
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

        ImageButton btClothingIcon = (ImageButton) findViewById(R.id.partner_clothing_icon);
        btClothingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerActivity.this, PartnerClothingActivity.class);
                startActivity(intent);
            }
        });
    }
}
