package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
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
    String category, subcategory;

    Query partner;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    String name_partner, category_partner, search_name;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
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
                //category_partner = partner.getCategory().toLowerCase();
                search_name = String.valueOf(sequence).toLowerCase();
                /*if (!name_partner.contains(search_name) && !category_partner.contains(search_name)) {
                    i.remove();
                }*/
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
                    p.setSubcategory((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_SUBCATEGORY).getValue());
                    p.setName((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_NAME).getValue());
                    p.setUrlLogo((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_URL_LOGO).getValue());
                    p.setDescription((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_DESCRIPTION).getValue());
                    p.setAddress((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_ADDRESS).getValue());
                    p.setPhone((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_PHONE).getValue());
                    p.setSite((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_SITE).getValue());
                    p.setLatitude((Double) postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_LATITUDE).getValue());
                    p.setLongitude((Double) postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PARTNER_LONGITUDE).getValue());

                    if(category.equals(Utility.TRADE) || category.equals(Utility.SERVICES)) {
                        partners.add(p);
                    }else if(p.getSubcategory().contains(subcategory)){
                        partners.add(p);
                    }
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

                frag = (PartnerFragment) getSupportFragmentManager().findFragmentByTag(Utility.KEY_MAIN_FRAGMENT);
                if(frag == null) {
                    frag = new PartnerFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.partners_fragment_container, frag, Utility.KEY_MAIN_FRAGMENT);
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

        if (actionBar!=null) {
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        category = getIntent().getStringExtra(Utility.CATEGORY);

        subcategory = getIntent().getStringExtra(Utility.SUBCATEGORY);

        banner = (ImageView) findViewById(R.id.partner_category_banner);

        if(actionBar!=null) {
            switch (category) {
                case Utility.FOOD:
                    actionBar.setTitle(R.string.screen_food);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_alimentacao_0006_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_alimentacao_0006_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_FOOD)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.ART_DESIGN:
                    actionBar.setTitle(R.string.screen_art_design);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_arte_design_0006_banner_pareiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_arte_design_0006_banner_pareiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_ART_DESIGN)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.BEAUTY:
                    actionBar.setTitle(R.string.screen_beauty);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_beleza_0006_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_beleza_0006_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_BEAUTY)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.CONSULTING:
                    actionBar.setTitle(R.string.screen_consulting);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_consultoria_0006_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_consultoria_0006_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_CONSULTING)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.EDUCATION:
                    actionBar.setTitle(R.string.screen_education);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_educacao_0006_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_educacao_0006_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_EDUCATION)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.SPORT:
                    actionBar.setTitle(R.string.screen_sport);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_esporte_0010_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_esporte_0010_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_SPORT)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.CLOTHING:
                    actionBar.setTitle(R.string.screen_clothing);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_vestuario_0010_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_vestuario_0010_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_CLOTHING)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.TOURISM:
                    actionBar.setTitle(R.string.screen_tourism);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_turismo_0011_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_turismo_0011_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_TOURISM)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.AUTO:
                    actionBar.setTitle(R.string.screen_auto);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_auto_0006_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_auto_0006_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_AUTO)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.TECH:
                    actionBar.setTitle(R.string.screen_tech);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_tecnologia_0012_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_tecnologia_0012_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_TECH)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.HEALTH:
                    actionBar.setTitle(R.string.screen_health);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_saude_0014_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_saude_0014_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_HEALTH)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.HOME:
                    actionBar.setTitle(R.string.screen_home);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_lar_construcao_0016_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_lar_construcao_0016_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_HOME)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.ENTERTAINMENT:
                    actionBar.setTitle(R.string.screen_entertainment);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_entretenimento_0006_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_entretenimento_0006_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_ENTERTAINMENT)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.WORLD_ANIMAL:
                    actionBar.setTitle(R.string.screen_world_animal);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_mundo_animal_0006_banner_parceiros, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_mundo_animal_0006_banner_parceiros);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_WORLD_ANIMAL)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.TRADE:
                    actionBar.setTitle(R.string.screen_trade);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.parceiros_0006_banner_comercio, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.parceiros_0006_banner_comercio);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_TRADE)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
                case Utility.SERVICES:
                    actionBar.setTitle(R.string.screen_services);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        banner.setImageDrawable(getResources().getDrawable(R.drawable.projeto_0006_banner_servicos, getApplicationContext().getTheme()));
                    } else {
                        banner.setImageResource(R.drawable.projeto_0006_banner_servicos);
                    }
                    partner = mDatabase
                            .child(FirebaseHelper.FIREBASE_DATABASE_SERVICES)
                            .orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY)
                            .equalTo(Utility.CITY);
                    break;
            }
        }
    }
}