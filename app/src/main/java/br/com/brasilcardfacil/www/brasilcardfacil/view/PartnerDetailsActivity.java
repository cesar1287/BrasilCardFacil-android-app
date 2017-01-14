package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.MapViewFragment;

public class PartnerDetailsActivity extends AppCompatActivity {

    MapViewFragment frag;

    Partner partner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_details);

        partner = (Partner) getIntent().getSerializableExtra("partner");

        setupUI();
    }

    public void setupUI(){

        frag = (MapViewFragment) getSupportFragmentManager().findFragmentByTag("mapFrag");
        if(frag == null) {
            frag = new MapViewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("partner", partner);
            frag.setArguments(bundle);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.map_fragment_container, frag, "mapFrag");
            ft.commit();
        }

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(partner.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView tv_name = (TextView) findViewById(R.id.partner_details_name);
        tv_name.setText(partner.getName());
        TextView tv_description = (TextView) findViewById(R.id.partner_details_description);
        tv_description.setText(partner.getDescription());
        TextView tv_address = (TextView) findViewById(R.id.partner_details_address);
        tv_address.setText(partner.getAddress());
        TextView tv_phone = (TextView) findViewById(R.id.partner_details_phone);
        tv_phone.setText(partner.getPhone());
        TextView tv_site = (TextView) findViewById(R.id.partner_details_site);
        tv_site.setText(partner.getSite());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
