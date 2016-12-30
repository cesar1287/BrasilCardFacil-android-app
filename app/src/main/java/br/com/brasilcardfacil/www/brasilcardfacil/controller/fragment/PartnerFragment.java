package br.com.brasilcardfacil.www.brasilcardfacil.controller.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.adapter.PartnerAdapter;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.interfaces.RecyclerViewOnClickListenerHack;
import br.com.brasilcardfacil.www.brasilcardfacil.view.AdvocacyPartnerActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.ClinicHospitalPartnerActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.DentistryPartnerActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.FuneralPartnerActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.LaboratoryPartnerActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.PartnerDetailsActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.TradePartnerActivity;
import br.com.brasilcardfacil.www.brasilcardfacil.view.VeterinaryPartnerActivity;

public class PartnerFragment extends Fragment implements RecyclerViewOnClickListenerHack {

    RecyclerView mRecyclerView;
    public List<Partner> mList;
    public PartnerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_partner, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        if(getActivity() instanceof FuneralPartnerActivity) {
            mList = ((FuneralPartnerActivity) getActivity()).getPartnersList();
        }else if(getActivity() instanceof TradePartnerActivity){
            mList = ((TradePartnerActivity) getActivity()).getPartnersList();
        }else if(getActivity() instanceof ClinicHospitalPartnerActivity){
            mList = ((ClinicHospitalPartnerActivity) getActivity()).getPartnersList();
        }else if(getActivity() instanceof DentistryPartnerActivity){
            mList = ((DentistryPartnerActivity) getActivity()).getPartnersList();
        }else if(getActivity() instanceof VeterinaryPartnerActivity){
            mList = ((VeterinaryPartnerActivity) getActivity()).getPartnersList();
        }else if(getActivity() instanceof LaboratoryPartnerActivity){
            mList = ((LaboratoryPartnerActivity) getActivity()).getPartnersList();
        }else if(getActivity() instanceof AdvocacyPartnerActivity){
            mList = ((AdvocacyPartnerActivity) getActivity()).getPartnersList();
        }
        adapter = new PartnerAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter( adapter );

        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener( getActivity(), mRecyclerView, this ));

        return view;

    }

    @Override
    public void onClickListener(View view, int position) {
        Intent intent = new Intent(getActivity(), PartnerDetailsActivity.class);
        intent.putExtra("partner", mList.get(position));
        startActivity(intent);
    }

    private static class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {
        private Context mContext;
        private GestureDetector mGestureDetector;
        private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

        RecyclerViewTouchListener(Context c, final RecyclerView rv, RecyclerViewOnClickListenerHack rvoclh){
            mContext = c;
            mRecyclerViewOnClickListenerHack = rvoclh;

            mGestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);

                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if(cv != null && mRecyclerViewOnClickListenerHack != null){
                        mRecyclerViewOnClickListenerHack.onClickListener(cv,
                                rv.getChildAdapterPosition(cv) );
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            mGestureDetector.onTouchEvent(e);
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}
