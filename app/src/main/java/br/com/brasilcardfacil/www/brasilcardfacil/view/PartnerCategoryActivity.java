package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.PartnerFragment;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class PartnerCategoryActivity extends AppCompatActivity {

    PartnerFragment frag;
    private DatabaseReference mDatabase;

    List<Partner> partners = new ArrayList<>();
    List<Partner> partners_aux = new ArrayList<>();

    private ProgressDialog dialog;
    ImageView banner;
    String category;

    Query partner;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    String name_partner, search_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_category);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        setupUI();

        dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_partners_pls_wait), true, false);

        loadList();

        setupListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        partner.removeEventListener(valueEventListener);
        partner.removeEventListener(singleValueEventListener);
    }

    public List<Partner> getPartnersList() {

        return partners;
    }

    public void setupListeners(){

        EditText editTextSearch = (EditText) findViewById(R.id.search_partner_category);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //TODO
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                execSearch(s, count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //TODO
            }
        });
    }

    public void execSearch(CharSequence sequence, int count){

        partners = new ArrayList<>(partners_aux);

        if(count!=0){
            for (Iterator<Partner> i = partners.iterator(); i.hasNext();) {
                Partner partner = i.next();
                name_partner = partner.getName().toLowerCase();
                search_name = String.valueOf(sequence).toLowerCase();
                if (!name_partner.contains(search_name)) {
                    i.remove();
                }
            }

            frag.mList.clear();
            frag.mList.addAll(getPartnersList());
            frag.adapter.notifyDataSetChanged();
        }else{

            frag.mList.clear();
            frag.mList.addAll(getPartnersList());
            frag.adapter.notifyDataSetChanged();
        }
    }

    public void loadList(){

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Partner p;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    p = new Partner();
                    p.setName((String)postSnapshot.child("name").getValue());
                    p.setUrlLogo((String)postSnapshot.child("url_logo").getValue());
                    p.setDescription((String)postSnapshot.child("description").getValue());
                    p.setAddress((String)postSnapshot.child("address").getValue());
                    p.setPhone((String)postSnapshot.child("phone").getValue());
                    p.setSite((String)postSnapshot.child("site").getValue());
                    p.setLatitude((Double) postSnapshot.child("latitude").getValue());
                    p.setLongitude((Double) postSnapshot.child("longitude").getValue());
                    partners.add(p);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(PartnerCategoryActivity.this, R.string.error_loading_partners, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        singleValueEventListener = new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {

                partners_aux = new ArrayList<>(partners);

                frag = (PartnerFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
                if(frag == null) {
                    frag = new PartnerFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.partners_fragment_container, frag, "mainFrag");
                    ft.commit();
                }

                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(PartnerCategoryActivity.this, R.string.error_loading_partners, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        partner.addValueEventListener(valueEventListener);

        partner.addListenerForSingleValueEvent(singleValueEventListener);
    }

    public void setupUI(){

        ActionBar actionBar = getSupportActionBar();

        category = getIntent().getStringExtra(Utility.CATEGORY);

        banner = (ImageView) findViewById(R.id.partner_category_banner);

        if(actionBar!=null) {
            switch (category) {
                case Utility.CLINIC:
                    actionBar.setTitle(R.string.screen_clinic);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_0006_banner_clinica_hosp, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_0006_banner_clinica_hosp);
                    }
                    partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_CLINIC).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY);
                    break;
                case Utility.ADVOCACY:
                    actionBar.setTitle(R.string.screen_advocacy);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_0006_banner_advocacia, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_0006_banner_advocacia);
                    }
                    partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_ADVOCACY).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY);
                    break;
                case Utility.VETERINARY:
                    actionBar.setTitle(R.string.screen_veterinary);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_0006_banner_veterinaria, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_0006_banner_veterinaria);
                    }
                    partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_VETERINARY).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY);
                    break;
                case Utility.LABORATORY:
                    actionBar.setTitle(R.string.screen_lab);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_0006_banner_lab, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_0006_banner_lab);
                    }
                    partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_LAB).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY);
                    break;
                case Utility.TRADE:
                    actionBar.setTitle(R.string.screen_trade);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_0006_banner_comercio, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_0006_banner_comercio);
                    }
                    partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_TRADE).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY);
                    break;
                case Utility.DENTISTRY:
                    actionBar.setTitle(R.string.screen_dentistry);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_0006_banner_odonto, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_0006_banner_odonto);
                    }
                    partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_DENTISTRY).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY);
                    break;
                case Utility.FUNERAL:
                    actionBar.setTitle(R.string.screen_funeral);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_0006_banner_funeraria, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_0006_banner_funeraria);
                    }
                    partner = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_FUNERAL).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY);
                    break;
            }
        }
    }
}
