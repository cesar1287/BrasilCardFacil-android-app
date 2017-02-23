package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Offer;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.OfferNotification;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.MapViewFragment;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class OfferDetailsActivity extends AppCompatActivity {

    MapViewFragment frag;
    
    Offer offer;

    String db, child;

    Query offer_notification;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        db = getIntent().getStringExtra(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE);
        child = getIntent().getStringExtra(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD);

        offer = (Offer) getIntent().getSerializableExtra(Utility.KEY_CONTENT_EXTRA_OFFER);

        if(db != null & child != null){

            dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_offer_pls_wait), true, false);
            offer_notification = mDatabase.child(db).child(child);

            loadOfferNotification();
        }else{
            setupUI();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(offer_notification!=null) {
            offer_notification.removeEventListener(valueEventListener);
            offer_notification.removeEventListener(singleValueEventListener);
        }
    }

    private void loadOfferNotification() {

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                OfferNotification offerNotification = dataSnapshot.getValue(OfferNotification.class);
                offer = new Offer();

                offer.setName(offerNotification.name);
                offer.setDescription(offerNotification.description);
                offer.setAddress(offerNotification.address);
                offer.setLatitude(offerNotification.latitude);
                offer.setLongitude(offerNotification.longitude);
                offer.setPhone(offerNotification.phone);
                offer.setAbout(offerNotification.about);
                offer.setUrlBanner(offerNotification.url_banner);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(OfferDetailsActivity.this, R.string.error_loading_offer, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        singleValueEventListener = new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {

                setupUI();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(OfferDetailsActivity.this, R.string.error_loading_offer, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        offer_notification.addValueEventListener(valueEventListener);

        offer_notification.addListenerForSingleValueEvent(singleValueEventListener);
    }

    public void setupUI(){

        frag = (MapViewFragment) getSupportFragmentManager().findFragmentByTag(Utility.KEY_MAP_FRAGMENT);
        if(frag == null) {
            frag = new MapViewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(Utility.KEY_CONTENT_EXTRA_OFFER, offer);
            frag.setArguments(bundle);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.map_fragment_container, frag, Utility.KEY_MAP_FRAGMENT);
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
