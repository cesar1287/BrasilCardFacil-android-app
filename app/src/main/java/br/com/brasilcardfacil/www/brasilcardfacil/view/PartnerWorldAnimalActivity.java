package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerWorldAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_world_animal);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btClinic = (ImageButton) findViewById(R.id.world_animal_clinic);
        btClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerWorldAnimalActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.WORLD_ANIMAL);
                intent.putExtra(Utility.SUBCATEGORY, Utility.WORLD_ANIMAL_SUBCATEGORY_CLINIC);
                startActivity(intent);
            }
        });

        ImageButton btHotel = (ImageButton) findViewById(R.id.world_animal_hotel);
        btHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerWorldAnimalActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.WORLD_ANIMAL);
                intent.putExtra(Utility.SUBCATEGORY, Utility.WORLD_ANIMAL_SUBCATEGORY_HOTEL);
                startActivity(intent);
            }
        });

        ImageButton btPetShop = (ImageButton) findViewById(R.id.world_animal_pet_shop);
        btPetShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerWorldAnimalActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.WORLD_ANIMAL);
                intent.putExtra(Utility.SUBCATEGORY, Utility.WORLD_ANIMAL_SUBCATEGORY_PET_SHOP);
                startActivity(intent);
            }
        });

        ImageButton btLab = (ImageButton) findViewById(R.id.world_animal_lab);
        btLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerWorldAnimalActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.WORLD_ANIMAL);
                intent.putExtra(Utility.SUBCATEGORY, Utility.WORLD_ANIMAL_SUBCATEGORY_LAB);
                startActivity(intent);
            }
        });

        ImageButton btVeterinary = (ImageButton) findViewById(R.id.world_animal_veterinary);
        btVeterinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerWorldAnimalActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.WORLD_ANIMAL);
                intent.putExtra(Utility.SUBCATEGORY, Utility.WORLD_ANIMAL_SUBCATEGORY_VETERINARY);
                startActivity(intent);
            }
        });
    }
}
