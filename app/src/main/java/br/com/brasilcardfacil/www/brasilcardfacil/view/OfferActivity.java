package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Offer;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.OfferFragment;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;

public class OfferActivity extends AppCompatActivity {

    List<Offer> offers;
    OfferFragment frag;

    private ProgressDialog dialog;

    Query offer;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        offer = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_OFFER).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY);

        dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_offers_pls_wait), true, false);

        loadList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        offer.removeEventListener(valueEventListener);
        offer.removeEventListener(singleValueEventListener);
    }

    public List<Offer> getPartnersList(){

        return offers;
    }

    public void loadList(){

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                offers = new ArrayList<>();

                Offer offer;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    offer = new Offer();
                    offer.setName((String)postSnapshot.child("name").getValue());
                    offer.setUrlBanner((String)postSnapshot.child("url_banner").getValue());
                    offer.setDescription((String)postSnapshot.child("description").getValue());
                    offer.setAddress((String)postSnapshot.child("address").getValue());
                    offer.setPhone((String)postSnapshot.child("phone").getValue());
                    offer.setAbout((String)postSnapshot.child("about").getValue());
                    offer.setLatitude((Double) postSnapshot.child("latitude").getValue());
                    offer.setLongitude((Double) postSnapshot.child("longitude").getValue());
                    offers.add(offer);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(OfferActivity.this, R.string.error_loading_offers, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        singleValueEventListener = new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {

                frag = (OfferFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
                if(frag == null) {
                    frag = new OfferFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.offer_fragment_container, frag, "mainFrag");
                    ft.commit();
                }

                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(OfferActivity.this, R.string.error_loading_offers, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        offer.addValueEventListener(valueEventListener);

        offer.addListenerForSingleValueEvent(singleValueEventListener);
    }
}
