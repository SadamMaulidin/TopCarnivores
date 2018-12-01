package com.tapperware.topcarnivores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    //TODO 1 membuat variable
    Context context;
    int[] gambarHewan;
    String[] namaHewan,detailHewan;

    public Adapter(Context context, int[] gambarHewan, String[] namaHewan, String[] detailHewan) {
        this.context = context;
        this.gambarHewan = gambarHewan;
        this.namaHewan = namaHewan;
        this.detailHewan = detailHewan;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_hewan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaHewan[i]);
        Glide.with(context).load(gambarHewan[i]).into(viewHolder.imgFoto);

        //TODO membuat onclicklistener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailHewan.class);
                pindah.putExtra("nh", namaHewan[i]);
                pindah.putExtra("dh", detailHewan[i]);
                pindah.putExtra("gh", gambarHewan[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarHewan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);
        }
    }
}
