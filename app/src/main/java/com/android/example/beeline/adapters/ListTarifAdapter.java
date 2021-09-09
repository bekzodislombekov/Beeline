package com.android.example.beeline.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.example.beeline.R;
import com.android.example.beeline.models.Tarif;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListTarifAdapter extends RecyclerView.Adapter<ListTarifAdapter.VH> {

    private List<Tarif> tarifList;
    private OnItemClickListener listener;

    public ListTarifAdapter(List<Tarif> tarifList, OnItemClickListener listener) {
        this.tarifList = tarifList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tarif, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Tarif tarif = tarifList.get(position);
        holder.tarifTxt.setText(tarif.getTextTarif());
        holder.moneyTxt.setText(tarif.getMoneyTxt());
        holder.callTxt.setText(tarif.getCallTxt());
        holder.netTxt.setText(tarif.getNetTxt());
        holder.messTxt.setText(tarif.getMessTxt());
        Picasso.get().load(tarif.getImgTarif()).into(holder.imgTarif);
        holder.card.setOnClickListener(v -> listener.onClickListener(tarif));
    }

    @Override
    public int getItemCount() {
        return tarifList.size();
    }

    class VH extends RecyclerView.ViewHolder {

        ImageView imgTarif;
        TextView tarifTxt;
        TextView moneyTxt;
        TextView callTxt;
        TextView netTxt;
        TextView messTxt;
        CardView card;

        public VH(@NonNull View itemView) {
            super(itemView);
            imgTarif = itemView.findViewById(R.id.circleImg);
            tarifTxt = itemView.findViewById(R.id.textTarif);
            moneyTxt = itemView.findViewById(R.id.textMoney);
            callTxt = itemView.findViewById(R.id.textCall);
            netTxt = itemView.findViewById(R.id.textNet);
            messTxt = itemView.findViewById(R.id.textMessage);
            card = itemView.findViewById(R.id.cardTarif);
        }
    }

    public interface OnItemClickListener {
        void onClickListener(Tarif tarif);
    }
}
