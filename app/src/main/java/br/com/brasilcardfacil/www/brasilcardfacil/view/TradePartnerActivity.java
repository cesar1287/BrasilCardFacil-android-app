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
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.PartnerFragment;

public class TradePartnerActivity extends AppCompatActivity {

    PartnerFragment frag;
    private DatabaseReference mDatabase;
    final List<Partner> partners = new ArrayList<>();
    private ProgressDialog dialog;

    Query partner;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_partner);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        dialog = ProgressDialog.show(this,"","Carregando parceiros, por favor aguarde!!!", true, false);

        loadList();
    }

    public List<Partner> getPartnersList(){

        return partners;
    }

    public void loadList(){
        partner = mDatabase.child("comercio").orderByChild("name");

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Partner p;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    p = new Partner();
                    p.setName((String)postSnapshot.child("name").getValue());
                    p.setUrlLogo((String)postSnapshot.child("url_logo").getValue());
                    p.setDescription((String)postSnapshot.child("description").getValue());
                    p.setPhone((String)postSnapshot.child("phone").getValue());
                    p.setSite((String)postSnapshot.child("site").getValue());
                    partners.add(p);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(TradePartnerActivity.this, "Algo deu errado ao carregar os parceiros, " +
                        "por favor contate o administrador.", Toast.LENGTH_LONG).show();
                finish();
            }
        };

        singleValueEventListener = new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                frag = (PartnerFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
                if(frag == null) {
                    frag = new PartnerFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.trade_fragment_container, frag, "mainFrag");
                    ft.commit();
                }

                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(TradePartnerActivity.this, "Algo deu errado ao carregar os parceiros, " +
                        "por favor contate o administrador.", Toast.LENGTH_LONG).show();
                finish();
            }
        };

        partner.addListenerForSingleValueEvent(singleValueEventListener);

        partner.addValueEventListener(valueEventListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        partner.removeEventListener(valueEventListener);
        partner.removeEventListener(singleValueEventListener);
    }
}
