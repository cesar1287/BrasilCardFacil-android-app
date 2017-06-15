package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerTradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_trade);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btStationery = (ImageButton) findViewById(R.id.trade_stationery);
        btStationery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTradeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TRADE_SUBCATEGORY_STATIONERY);
                startActivity(intent);
            }
        });

        ImageButton btHome = (ImageButton) findViewById(R.id.trade_home);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTradeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TRADE_SUBCATEGORY_HOME);
                startActivity(intent);
            }
        });

        ImageButton btDepartament = (ImageButton) findViewById(R.id.trade_departament);
        btDepartament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTradeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TRADE_SUBCATEGORY_DEPARTAMENT);
                startActivity(intent);
            }
        });

        ImageButton btFloriculture = (ImageButton) findViewById(R.id.trade_floriculture);
        btFloriculture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTradeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TRADE_SUBCATEGORY_FLORICULTURE);
                startActivity(intent);
            }
        });

        ImageButton btJewelry = (ImageButton) findViewById(R.id.trade_jewelry);
        btJewelry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTradeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TRADE_SUBCATEGORY_JEWELRY);
                startActivity(intent);
            }
        });

        ImageButton btOptical = (ImageButton) findViewById(R.id.trade_optical);
        btOptical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTradeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TRADE_SUBCATEGORY_OPTICAL);
                startActivity(intent);
            }
        });

        ImageButton btSecurity = (ImageButton) findViewById(R.id.trade_security);
        btSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTradeActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TRADE);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TRADE_SUBCATEGORY_SECURITY);
                startActivity(intent);
            }
        });
    }
}
