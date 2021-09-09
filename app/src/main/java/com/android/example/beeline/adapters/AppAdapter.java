package com.android.example.beeline.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.example.beeline.R;
import com.android.example.beeline.models.App;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.VH> {
    private List<App> appList;

    public AppAdapter(List<App> appList) {
        this.appList = appList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        App app = appList.get(position);
        holder.name.setText(app.getName());
        holder.des.setText(app.getDes());
        holder.btn.setText(app.getName());
        ItemAppAdapter itemAppAdapter = new ItemAppAdapter(app.getImageList());
        holder.rv.setAdapter(itemAppAdapter);
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("#F3F3F3"));
        }
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }


    class VH extends RecyclerView.ViewHolder {
        RecyclerView rv;
        TextView name;
        TextView des;
        Button btn;

        public VH(@NonNull View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv_item_app);
            name = itemView.findViewById(R.id.appName);
            des = itemView.findViewById(R.id.desText);
            btn = itemView.findViewById(R.id.appBtn);
        }
    }
}
