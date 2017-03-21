package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.adapter.MySpinnerAdapter;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerSelectionLocalActivity extends AppCompatActivity {

    Spinner spinnerStates, spinnerCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_selection_local);

        setupUI();

        setupListeners();
    }

    private void setupListeners() {

        ImageButton btSearch = (ImageButton) findViewById(R.id.SelectionLocalSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.STATE = "Estado";
                Utility.CITY = "Cidade";

                if (spinnerStates.getSelectedItem().toString().equals(Utility.STATE) ||
                    spinnerCities.getSelectedItem().toString().equals(Utility.CITY)){

                    Toast.makeText(PartnerSelectionLocalActivity.this, "Selecione o Estado e a Cidade para buscar.", Toast.LENGTH_SHORT).show();
                }else{

                    Utility.STATE = spinnerStates.getSelectedItem().toString();
                    Utility.CITY = spinnerCities.getSelectedItem().toString();

                    startActivity(new Intent(PartnerSelectionLocalActivity.this, PartnerActivity.class));
                }
            }
        });
    }

    private void setupUI() {

        spinnerStates = (Spinner) findViewById(R.id.spinner_state);
        MySpinnerAdapter adapterStates = new MySpinnerAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(getResources().getStringArray(R.array.states))
        );
        spinnerStates.setAdapter(adapterStates);

        spinnerCities = (Spinner) findViewById(R.id.spinner_city);
        MySpinnerAdapter adapterCities = new MySpinnerAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(getResources().getStringArray(R.array.cities))
        );
        spinnerCities.setAdapter(adapterCities);
    }
}
