package com.android.example.beeline.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.example.beeline.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAppAdapter extends RecyclerView.Adapter<ItemAppAdapter.VH> {
    private List<String> imageViewList;
    private Context context;

    public ItemAppAdapter(List<String> imageViewList) {
        this.imageViewList = imageViewList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item_app, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Picasso.get().load(imageViewList.get(position)).into(holder.img);
        if (position == 0) {

        }
    }

    @Override
    public int getItemCount() {
        return imageViewList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView img;
        CardView cardView;

        public VH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.app_img);
            cardView = itemView.findViewById(R.id.card_item);
        }
    }
}
