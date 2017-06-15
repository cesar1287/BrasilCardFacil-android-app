package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerBeautyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_beauty);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btAesthetics = (ImageButton) findViewById(R.id.beauty_aesthetics);
        btAesthetics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerBeautyActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.BEAUTY);
                intent.putExtra(Utility.SUBCATEGORY, Utility.BEAUTY_SUBCATEGORY_AESTHETICS);
                startActivity(intent);
            }
        });

        ImageButton btPerfumery = (ImageButton) findViewById(R.id.beauty_perfumery);
        btPerfumery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerBeautyActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.BEAUTY);
                intent.putExtra(Utility.SUBCATEGORY, Utility.BEAUTY_SUBCATEGORY_PERFUMERY);
                startActivity(intent);
            }
        });

        ImageButton btBarberShop = (ImageButton) findViewById(R.id.beauty_barber_shop);
        btBarberShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerBeautyActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.BEAUTY);
                intent.putExtra(Utility.SUBCATEGORY, Utility.BEAUTY_SUBCATEGORY_BARBER_SHOP);
                startActivity(intent);
            }
        });

        ImageButton btBeautySalon = (ImageButton) findViewById(R.id.beauty_beauty_salon);
        btBeautySalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerBeautyActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.BEAUTY);
                intent.putExtra(Utility.SUBCATEGORY, Utility.BEAUTY_SUBCATEGORY_BEAUTY_SALON);
                startActivity(intent);
            }
        });

        ImageButton btManicure = (ImageButton) findViewById(R.id.beauty_manicure);
        btManicure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerBeautyActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.BEAUTY);
                intent.putExtra(Utility.SUBCATEGORY, Utility.BEAUTY_SUBCATEGORY_MANICURE);
                startActivity(intent);
            }
        });

        ImageButton btMakeUp = (ImageButton) findViewById(R.id.beauty_make_up);
        btMakeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerBeautyActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.BEAUTY);
                intent.putExtra(Utility.SUBCATEGORY, Utility.BEAUTY_SUBCATEGORY_MAKE_UP);
                startActivity(intent);
            }
        });

    }

}
