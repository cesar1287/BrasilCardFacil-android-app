package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerSportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_sport);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btGym = (ImageButton) findViewById(R.id.sport_gym);
        btGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerSportActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.SPORT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.SPORT_SUBCATEGORY_GYM);
                startActivity(intent);
            }
        });

        ImageButton btPersonal = (ImageButton) findViewById(R.id.sport_personal);
        btPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerSportActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.SPORT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.SPORT_SUBCATEGORY_PERSONAL);
                startActivity(intent);
            }
        });

        ImageButton btSupplement = (ImageButton) findViewById(R.id.sport_supplement);
        btSupplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerSportActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.SPORT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.SPORT_SUBCATEGORY_SUPPLEMENT);
                startActivity(intent);
            }
        });

        ImageButton btClothing = (ImageButton) findViewById(R.id.sport_clothing);
        btClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerSportActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.SPORT);
                intent.putExtra(Utility.SUBCATEGORY, Utility.SPORT_SUBCATEGORY_CLOTHING);
                startActivity(intent);
            }
        });
    }
}
