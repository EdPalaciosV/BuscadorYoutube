package com.example.usuario.buscadoryoutube.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.buscadoryoutube.Adapters.Holder.HolderItems;
import com.example.usuario.buscadoryoutube.POJO.MisItem;
import com.example.usuario.buscadoryoutube.R;
import com.example.usuario.buscadoryoutube.VistaLista.onClickItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class AdapterItems  extends RecyclerView.Adapter<HolderItems>{

    List<MisItem> items;
    Context context;
    onClickItem onClickItem;
    public AdapterItems(Context context,List<MisItem> items)
    {
        this.context=context;
        this.items=items;
        onClickItem=(onClickItem)context;

    }
    @Override
    public HolderItems onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        view=inflater.inflate(R.layout.disenio_recyclerview,viewGroup,false);
        HolderItems holderItems =new HolderItems(view);

        return holderItems;
    }

    @Override
    public void onBindViewHolder(HolderItems holderItems, final int position) {


        holderItems.titulo.setText(items.get(position).getTitulo());
        holderItems.canal.setText(items.get(position).getCanal());
        Picasso.with(context).load(items.get(position).getImagen()).into(holderItems.imagen);

       /* holderItems.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickItem.onclickRecyclerView(position);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
