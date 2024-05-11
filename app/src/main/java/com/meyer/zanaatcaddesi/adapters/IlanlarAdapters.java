package com.meyer.zanaatcaddesi.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IlanlarAdapters extends RecyclerView.Adapter<IlanlarAdapters.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView popimg;
        TextView baslik,aciklama,konum,fiyat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
