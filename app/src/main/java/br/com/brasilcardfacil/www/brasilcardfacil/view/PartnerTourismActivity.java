package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerTourismActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_tourism);

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btTravelAgency = (ImageButton) findViewById(R.id.tourism_travel_agency);
        btTravelAgency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTourismActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TOURISM);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TOURISM_SUBCATEGORY_TRAVEL_AGENCY);
                startActivity(intent);
            }
        });

        ImageButton btGuide = (ImageButton) findViewById(R.id.tourism_guide);
        btGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTourismActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TOURISM);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TOURISM_SUBCATEGORY_GUIDE);
                startActivity(intent);
            }
        });

        ImageButton btHostel = (ImageButton) findViewById(R.id.tourism_hostel);
        btHostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTourismActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TOURISM);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TOURISM_SUBCATEGORY_HOSTEL);
                startActivity(intent);
            }
        });

        ImageButton btHotel = (ImageButton) findViewById(R.id.tourism_hotel);
        btHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTourismActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TOURISM);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TOURISM_SUBCATEGORY_HOTEL);
                startActivity(intent);
            }
        });

        ImageButton btTransport = (ImageButton) findViewById(R.id.tourism_transport);
        btTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartnerTourismActivity.this, PartnerCategoryActivity.class);
                intent.putExtra(Utility.CATEGORY, Utility.TOURISM);
                intent.putExtra(Utility.SUBCATEGORY, Utility.TOURISM_SUBCATEGORY_TRANSPORT);
                startActivity(intent);
            }
        });
    }
}
