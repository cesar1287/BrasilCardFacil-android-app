package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.PartnerFragment;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.util.Utility;
import br.com.brasilcardfacil.www.brasilcardfacil.model.BrasilCardFacilDAO;

public class FavActivity extends AppCompatActivity {

    List<Partner> partners = new ArrayList<>();
    PartnerFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        setupUI();
    }

    @Override
    protected void onResume() {
        super.onResume();

        refreshList();
    }

    public List<Partner> getPartnersList() {

        loadlist();

        return partners;
    }

    private void loadlist() {

        BrasilCardFacilDAO dao = new BrasilCardFacilDAO(getApplicationContext());

        String id_user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        partners = dao.getFavs(id_user);

        dao.close();
    }

    public void refreshList(){
        frag.mList.clear();
        frag.mList.addAll(getPartnersList());
        frag.adapter.notifyDataSetChanged();
    }

    public void setupUI(){

        frag = (PartnerFragment) getSupportFragmentManager().findFragmentByTag(Utility.KEY_MAIN_FRAGMENT);
        if(frag == null) {
            frag = new PartnerFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fav_fragment_container, frag, Utility.KEY_MAIN_FRAGMENT);
            ft.commit();
        }
    }
}
