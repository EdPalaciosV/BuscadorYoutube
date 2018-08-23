package com.example.usuario.buscadoryoutube.Adapters.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.buscadoryoutube.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HolderItems extends RecyclerView.ViewHolder {


    @BindView(R.id.TV_titulo)
    public TextView titulo;

    @BindView(R.id.TV_Canal)
    public TextView canal;

    @BindView(R.id.IV_imagen)
    public ImageView imagen;

    @BindView(R.id.CV)
    public CardView cardView;


    public HolderItems(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
