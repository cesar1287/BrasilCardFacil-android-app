package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.app.ProgressDialog;
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
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.ActiveHealth;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.ActiveHealthNotification;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class ActiveHealthDetailsActivity extends AppCompatActivity {

    ActiveHealth activeHealth = new ActiveHealth();

    String db, child;

    Query active_health_notification;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_health_details);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        db = getIntent().getStringExtra(FirebaseHelper.FIREBASE_NOTIFICATION_DATABASE);
        child = getIntent().getStringExtra(FirebaseHelper.FIREBASE_NOTIFICATION_CHILD);

        activeHealth = (ActiveHealth) getIntent().getSerializableExtra(Utility.KEY_CONTENT_EXTRA_ACTIVE_HEALTH);

        if(db != null & child != null){

            dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_active_health_pls_wait), true, false);
            active_health_notification = mDatabase.child(db).child(child);

            loadActiveHealthNotification();
        }else{
            setupUI();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(active_health_notification!=null) {
            active_health_notification.removeEventListener(valueEventListener);
            active_health_notification.removeEventListener(singleValueEventListener);
        }
    }

    private void loadActiveHealthNotification() {

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ActiveHealthNotification activeHealthNotification = dataSnapshot.getValue(ActiveHealthNotification.class);
                activeHealth = new ActiveHealth();

                activeHealth.setTitle(activeHealthNotification.title);
                activeHealth.setDescription(activeHealthNotification.description);
                activeHealth.setUrlBanner(activeHealthNotification.url_banner);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ActiveHealthDetailsActivity.this, R.string.error_loading_active_health, Toast.LENGTH_LONG).show();
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
                Toast.makeText(ActiveHealthDetailsActivity.this, R.string.error_loading_active_health, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        active_health_notification.addValueEventListener(valueEventListener);

        active_health_notification.addListenerForSingleValueEvent(singleValueEventListener);
    }

    private void setupUI() {

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(activeHealth.getTitle());
        }

        ImageView iv_banner = (ImageView) findViewById(R.id.active_health_details_banner);
        Glide.with(this).load(activeHealth.getUrlBanner()).into(iv_banner);
        TextView tv_title = (TextView) findViewById(R.id.active_health_details_title);
        tv_title.setText(activeHealth.getTitle());
        TextView tv_description = (TextView) findViewById(R.id.active_health_details_description);
        tv_description.setText(activeHealth.getDescription());
    }
}
