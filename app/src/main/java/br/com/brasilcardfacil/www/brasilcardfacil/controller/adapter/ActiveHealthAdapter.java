package br.com.brasilcardfacil.www.brasilcardfacil.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.ActiveHealth;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.interfaces.RecyclerViewOnClickListenerHack;

public class ActiveHealthAdapter extends RecyclerView.Adapter<ActiveHealthAdapter.MyViewHolder>{

    private List<ActiveHealth> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    private Context c;

    public ActiveHealthAdapter(Context c, List<ActiveHealth> l){
        this.c = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ActiveHealthAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = mLayoutInflater.inflate(R.layout.item_active_health, viewGroup, false);
        return new ActiveHealthAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ActiveHealthAdapter.MyViewHolder myViewHolder, int position) {

        Glide.with(c)
                .load(mList.get((position)).getUrlBanner())
                .into(myViewHolder.bannerActiveHealth);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener /*View.OnCreateContextMenuListener*/{
        ImageView bannerActiveHealth;

        MyViewHolder(View itemView) {
            super(itemView);
            bannerActiveHealth = (ImageView) itemView.findViewById(R.id.active_health_logo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(v, getAdapterPosition());
            }
        }
    }
}
