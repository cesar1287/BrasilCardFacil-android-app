package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.PartnerNotification;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.MapViewFragment;
import br.com.brasilcardfacil.www.brasilcardfacil.model.BrasilCardFacilDAO;

public class PartnerDetailsActivity extends AppCompatActivity {

    MapViewFragment frag;

    Partner partner;

    BrasilCardFacilDAO dao;
    String id_user, db, child;

    Query partner_notification;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_details);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        dao = new BrasilCardFacilDAO(getApplicationContext());
        id_user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        db = getIntent().getStringExtra("db");
        child = getIntent().getStringExtra("child");

        partner = (Partner) getIntent().getSerializableExtra("partner");

        if(db != null & child != null){

            dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_partner_pls_wait), true, false);
            partner_notification = mDatabase.child(db).child(child);

            loadPartnerNotification();
        }else{
            setupUI();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(partner_notification!=null) {
            partner_notification.removeEventListener(valueEventListener);
            partner_notification.removeEventListener(singleValueEventListener);
        }
    }

    private void loadPartnerNotification() {

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                PartnerNotification partnerNotification = dataSnapshot.getValue(PartnerNotification.class);
                partner = new Partner();

                partner.setName(partnerNotification.name);
                partner.setDescription(partnerNotification.description);
                partner.setAddress(partnerNotification.address);
                partner.setLatitude(partnerNotification.latitude);
                partner.setLongitude(partnerNotification.longitude);
                partner.setPhone(partnerNotification.phone);
                partner.setSite(partnerNotification.site);
                partner.setUrlLogo(partnerNotification.url_logo);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(PartnerDetailsActivity.this, R.string.error_loading_partner, Toast.LENGTH_LONG).show();
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
                Toast.makeText(PartnerDetailsActivity.this, R.string.error_loading_partner, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        partner_notification.addValueEventListener(valueEventListener);

        partner_notification.addListenerForSingleValueEvent(singleValueEventListener);
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
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_fav:

                if(dao.isFav(id_user, partner.getUrlLogo())){
                    dao.delete(id_user, partner.getUrlLogo());
                    item.setIcon(R.drawable.ic_heart_outline_white_48dp);
                    Toast.makeText(this, "Parceiro removido dos favoritos", Toast.LENGTH_SHORT).show();
                }else {
                    dao.insertFav(id_user, partner);
                    dao.close();
                    item.setIcon(R.drawable.ic_heart_white_48dp);
                    Toast.makeText(this, "Parceiro adicionado aos favoritos", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fav, menu);

        if(partner!=null) {
            if (dao.isFav(id_user, partner.getUrlLogo())) {
                menu.getItem(0).setIcon(R.drawable.ic_heart_white_48dp);
            } else {
                menu.getItem(0).setIcon(R.drawable.ic_heart_outline_white_48dp);
            }
        }
        return true;
    }


}
