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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.PartnersMapViewFragment;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;

public class PartnersMapActivity extends AppCompatActivity {

    PartnersMapViewFragment frag;

    List<Partner> partners = new ArrayList<>();

    private ProgressDialog dialog;

    Query partner;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners_map);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_PARTNERS_LOCALIZATION);

        dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_partners_pls_wait), true, false);

        loadList();
    }

    public void loadList(){

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Partner p;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    p = new Partner();
                    p.setName((String)postSnapshot.child("name").getValue());
                    p.setLatitude((Double) postSnapshot.child("latitude").getValue());
                    p.setLongitude((Double) postSnapshot.child("longitude").getValue());
                    partners.add(p);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(PartnersMapActivity.this, R.string.error_loading_partners, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        singleValueEventListener = new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {

                frag = (PartnersMapViewFragment) getSupportFragmentManager().findFragmentByTag("mapFrag");
                if(frag == null) {
                    frag = new PartnersMapViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("partners", (Serializable) partners);
                    frag.setArguments(bundle);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.partners_map_fragment_container, frag, "mapFrag");
                    ft.commit();
                }

                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(PartnersMapActivity.this, R.string.error_loading_partners, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        partner.addValueEventListener(valueEventListener);

        partner.addListenerForSingleValueEvent(singleValueEventListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        partner.removeEventListener(valueEventListener);
        partner.removeEventListener(singleValueEventListener);
    }
}
