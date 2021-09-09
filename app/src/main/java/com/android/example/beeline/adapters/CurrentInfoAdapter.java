package com.android.example.beeline.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.example.beeline.R;
import com.android.example.beeline.models.CurrentInfo;

import java.util.List;

public class CurrentInfoAdapter extends RecyclerView.Adapter<CurrentInfoAdapter.VH> {

    private List<CurrentInfo> currentInfoList;

    public CurrentInfoAdapter(List<CurrentInfo> currentInfoList) {
        this.currentInfoList = currentInfoList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_current_info, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        CurrentInfo currentInfo = currentInfoList.get(position);
        holder.money.setText(currentInfo.getMoney());
        holder.des.setText(currentInfo.getDes());
        holder.img.setImageResource(currentInfo.getImg());
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("#F3F3F3"));
        }
    }

    @Override
    public int getItemCount() {
        return currentInfoList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView des;
        TextView money;

        public VH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgInfo);
            des = itemView.findViewById(R.id.textInfo);
            money = itemView.findViewById(R.id.textMoney);
        }
    }
}
