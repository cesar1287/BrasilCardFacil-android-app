package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerClothingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_clothing);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btShoes = (ImageButton) findViewById(R.id.clothing_shoes);
        btShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerClothingActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.CLOTHING);
                intent.putExtra(Utility.SUBCATEGORY, Utility.CLOTHING_SUBCATEGORY_SHOES);
                startActivity(intent);
            }
        });

        ImageButton btChildlike = (ImageButton) findViewById(R.id.clothing_childlike);
        btChildlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerClothingActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.CLOTHING);
                intent.putExtra(Utility.SUBCATEGORY, Utility.CLOTHING_SUBCATEGORY_CHILDLIKE);
                startActivity(intent);
            }
        });

        ImageButton btBeach = (ImageButton) findViewById(R.id.clothing_beach);
        btBeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerClothingActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.CLOTHING);
                intent.putExtra(Utility.SUBCATEGORY, Utility.CLOTHING_SUBCATEGORY_BEACH);
                startActivity(intent);
            }
        });

        ImageButton btGarment = (ImageButton) findViewById(R.id.clothing_garment);
        btGarment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerClothingActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.CLOTHING);
                intent.putExtra(Utility.SUBCATEGORY, Utility.CLOTHING_SUBCATEGORY_GARMENT);
                startActivity(intent);
            }
        });
    }
}