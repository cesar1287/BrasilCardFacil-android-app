package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerArtDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_art_design);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btAgency = (ImageButton) findViewById(R.id.art_design_agency);
        btAgency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerArtDesignActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ART_DESIGN);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ART_DESIGN_SUBCATEGORY_AGENCY);
                startActivity(intent);
            }
        });

        ImageButton btArt = (ImageButton) findViewById(R.id.art_design_art);
        btArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerArtDesignActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ART_DESIGN);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ART_DESIGN_SUBCATEGORY_ART);
                startActivity(intent);
            }
        });

        ImageButton btDecoration = (ImageButton) findViewById(R.id.art_design_decoration);
        btDecoration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerArtDesignActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ART_DESIGN);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ART_DESIGN_SUBCATEGORY_DECORATION);
                startActivity(intent);
            }
        });

        ImageButton btDesign = (ImageButton) findViewById(R.id.art_design_design);
        btDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerArtDesignActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ART_DESIGN);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ART_DESIGN_SUBCATEGORY_DESIGN);
                startActivity(intent);
            }
        });

        ImageButton btGraphics = (ImageButton) findViewById(R.id.art_design_graphics);
        btGraphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerArtDesignActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.ART_DESIGN);
                intent.putExtra(Utility.SUBCATEGORY, Utility.ART_DESIGN_SUBCATEGORY_GRAPHICS);
                startActivity(intent);
            }
        });
    }
}
