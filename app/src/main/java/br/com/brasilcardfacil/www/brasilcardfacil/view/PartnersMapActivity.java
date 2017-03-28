package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.PartnersMapViewFragment;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnersMapActivity extends AppCompatActivity {

    PartnersMapViewFragment frag;

    List<Partner> partners = new ArrayList<>();
    List<Partner> partners_aux = new ArrayList<>();

    private ProgressDialog dialog;

    Query partner;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    String name_partner, category_partner, search_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners_map);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_PARTNERS_LOCALIZATION);

        dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_partners_pls_wait), true, false);

        loadList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //Carrega o arquivo de menu.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        //Pega o Componente.
        SearchView mSearchView = (SearchView) menu.findItem(R.id.search)
                .getActionView();
        //Define um texto de ajuda:
        mSearchView.setQueryHint("Buscar por tag");

        // exemplos de utilização:
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                partners = new ArrayList<>(partners_aux);

                if(newText.length()!=0){
                    for (Iterator<Partner> i = partners.iterator(); i.hasNext();) {
                        Partner partner = i.next();
                        name_partner = partner.getName().toLowerCase();
                        //category_partner = partner.getCategory().toLowerCase();
                        search_name = String.valueOf(newText).toLowerCase();
                        /*if (!name_partner.contains(search_name) && !category_partner.contains(search_name)) {
                            i.remove();
                        }*/
                        if (!name_partner.contains(search_name)) {
                            i.remove();
                        }
                    }

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.detach(frag);
                    ft.attach(frag);
                    ft.commit();

                    /*frag.mList.clear();
                    frag.mList.addAll(getPartnersList());
                    frag.adapter.notifyDataSetChanged();*/
                }else{

                    /*frag.mList.clear();
                    frag.mList.addAll(getPartnersList());
                    frag.adapter.notifyDataSetChanged();*/
                }

                return false;
            }
        });

        return true;
    }

    public void loadList(){

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Partner p;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    p = new Partner();
                    p.setName((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_NAME).getValue());
                    p.setLatitude((Double) postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_LATITUDE).getValue());
                    p.setLongitude((Double) postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_LONGITUDE).getValue());
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

                partners_aux = new ArrayList<>(partners);

                frag = (PartnersMapViewFragment) getSupportFragmentManager().findFragmentByTag(Utility.KEY_MAP_FRAGMENT);
                if(frag == null) {
                    frag = new PartnersMapViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Utility.KEY_CONTENT_EXTRA_ACTIVE_PARTNERS_NEARBY, (Serializable) partners);
                    frag.setArguments(bundle);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.partners_map_fragment_container, frag, Utility.KEY_MAP_FRAGMENT);
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
