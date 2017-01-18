package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Offer;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.MapViewFragment;

public class OfferDetailsActivity extends AppCompatActivity {

    MapViewFragment frag;
    
    Offer offer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);

        offer = (Offer) getIntent().getSerializableExtra("offer");

        setupUI();
    }

    public void setupUI(){

        frag = (MapViewFragment) getSupportFragmentManager().findFragmentByTag("mapFrag");
        if(frag == null) {
            frag = new MapViewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("offer", offer);
            frag.setArguments(bundle);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.map_fragment_container, frag, "mapFrag");
            ft.commit();
        }

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(offer.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ImageView iv_banner = (ImageView) findViewById(R.id.offer_details_banner);
        Glide.with(this).load(offer.getUrlBanner()).into(iv_banner);
        TextView tv_name = (TextView) findViewById(R.id.offer_details_name);
        tv_name.setText(offer.getName());
        TextView tv_description = (TextView) findViewById(R.id.offer_details_description);
        tv_description.setText(offer.getDescription());
        TextView tv_about = (TextView) findViewById(R.id.offer_details_about);
        tv_about.setText(offer.getAbout());
        TextView tv_address = (TextView) findViewById(R.id.offer_details_address);
        tv_address.setText(offer.getAddress());
        TextView tv_phone = (TextView) findViewById(R.id.offer_details_phone);
        tv_phone.setText(offer.getPhone());
    }
}
