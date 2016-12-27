package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment.PartnerFragment;

public class FuneralPartnerActivity extends AppCompatActivity {

    PartnerFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funeral_partner);

        frag = (PartnerFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag == null) {
            frag = new PartnerFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.funeral_fragment_container, frag, "mainFrag");
            ft.commit();
        }
    }

    public List<Partner> getPartnersList(){

        Partner p1 = new Partner();
        p1.setName("teste");
        Partner p2 = new Partner();
        p2.setName("teste");
        Partner p3 = new Partner();
        p3.setName("teste");
        Partner p4 = new Partner();
        p4.setName("teste");
        Partner p5 = new Partner();
        p5.setName("teste");
        Partner p6 = new Partner();
        p6.setName("teste");
        Partner p7 = new Partner();
        p7.setName("teste");
        Partner p8 = new Partner();
        p8.setName("teste");

        List<Partner> partners = new ArrayList<>();
        partners.add(p1);
        partners.add(p2);
        partners.add(p3);
        partners.add(p4);
        partners.add(p5);
        partners.add(p6);
        partners.add(p7);
        partners.add(p8);

        return partners;
    }
}
