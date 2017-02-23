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
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.ActiveHealth;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.ActiveHealthFragment;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;

public class ActiveHealthActivity extends AppCompatActivity {

    List<ActiveHealth> activeHealths;

    private ProgressDialog dialog;

    ActiveHealthFragment frag;

    Query activeHealth;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_health);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        activeHealth = mDatabase.child(FirebaseHelper.FIREBASE_DATABASE_ACTIVE_HEALTH).orderByChild(FirebaseHelper.FIREBASE_DATABASE_ORDERBY_TITLE);

        dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_tips_pls_wait), true, false);

        loadList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        activeHealth.removeEventListener(valueEventListener);
        activeHealth.removeEventListener(singleValueEventListener);
    }

    public List<ActiveHealth> getPartnersList(){

        return activeHealths;
    }

    public void loadList(){

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                activeHealths = new ArrayList<>();

                ActiveHealth activeHealth;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    activeHealth= new ActiveHealth();
                    activeHealth.setTitle((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_ACTIVE_HEALTH_TITLE).getValue());
                    activeHealth.setUrlBanner((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_ACTIVE_HEALTH_URL_BANNER).getValue());
                    activeHealth.setDescription((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_ACTIVE_HEALTH_DESCRIPTION).getValue());
                    activeHealths.add(activeHealth);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ActiveHealthActivity.this, R.string.error_loading_tips, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        singleValueEventListener = new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {

                frag = (ActiveHealthFragment) getSupportFragmentManager().findFragmentByTag(Utility.KEY_MAIN_FRAGMENT);
                if(frag == null) {
                    frag = new ActiveHealthFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.active_health_fragment_container, frag, Utility.KEY_MAIN_FRAGMENT);
                    ft.commit();
                }

                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ActiveHealthActivity.this, R.string.error_loading_tips, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        activeHealth.addValueEventListener(valueEventListener);

        activeHealth.addListenerForSingleValueEvent(singleValueEventListener);
    }
}
