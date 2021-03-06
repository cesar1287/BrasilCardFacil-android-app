package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_food);

        setupListeners();
    }

    public void setupListeners(){

        ImageButton btSteakHouse = (ImageButton) findViewById(R.id.food_steak_house);
        btSteakHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_STEAK_HOUSE);
                startActivity(intent);
            }
        });

        ImageButton btSkewer = (ImageButton) findViewById(R.id.food_skewer);
        btSkewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_SKEWER);
                startActivity(intent);
            }
        });

        ImageButton btFood = (ImageButton) findViewById(R.id.food_bakery);
        btFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_BAKERY);
                startActivity(intent);
            }
        });

        ImageButton btArtDegign = (ImageButton) findViewById(R.id.food_distributor);
        btArtDegign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_DISTRIBUTOR);
                startActivity(intent);
            }
        });

        ImageButton btDelivery = (ImageButton) findViewById(R.id.food_delivery);
        btDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_DELIVERY);
                startActivity(intent);
            }
        });

        ImageButton btAuto = (ImageButton) findViewById(R.id.food_pub_coffee);
        btAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_PUB);
                startActivity(intent);
            }
        });

        ImageButton btBeauty = (ImageButton) findViewById(R.id.food_restaurant);
        btBeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_RESTAURANT);
                startActivity(intent);
            }
        });

        ImageButton btConsulting = (ImageButton) findViewById(R.id.food_supermarket);
        btConsulting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_SUPERMARKET);
                startActivity(intent);
            }
        });

        ImageButton btEducation = (ImageButton) findViewById(R.id.food_water_gas);
        btEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerFoodActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.FOOD);
                intent.putExtra(Utility.SUBCATEGORY, Utility.FOOD_SUBCATEGORY_WATER);
                startActivity(intent);
            }
        });
    }
}
