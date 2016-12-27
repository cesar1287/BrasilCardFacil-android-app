package br.com.brasilcardfacil.www.brasilcardfacil.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.R;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.interfaces.RecyclerViewOnClickListenerHack;

public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.MyViewHolder>{

    private List<Partner> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    ContextMenu.ContextMenuInfo info;
    private Context c;

    public PartnerAdapter(Context c, List<Partner> l){
        this.c = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    PartnerAdapter(){}

    @Override
    public PartnerAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        Log.i("LOG", "onCreateViewHolder()");
        View v = mLayoutInflater.inflate(R.layout.item_partner, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Log.i("LOG", "onBindViewHolder()");
        //myViewHolder.picPartner.setText(mList.get(position).getUrlLogo());
        myViewHolder.namePartner.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener /*View.OnCreateContextMenuListener*/{
        ImageView picPartner;
        TextView namePartner;

        MyViewHolder(View itemView) {
            super(itemView);
            picPartner = (ImageView) itemView.findViewById(R.id.partner_logo);
            namePartner = (TextView) itemView.findViewById(R.id.partner_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(v, getAdapterPosition());
            }
        }

        /*@Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            /*new AtividadeAdapter().info = menuInfo;
            menu.setHeaderTitle("Selecione a ação desejada");
            menu.add(0, R.id.itemContextMenuEditar, 0, "Editar");//groupId, itemId, order, title
            menu.add(0, R.id.itemContextMenuDeletar, 0, "Deletar");
        }*/
    }
}
