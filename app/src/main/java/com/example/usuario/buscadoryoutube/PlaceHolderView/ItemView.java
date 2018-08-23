package com.example.usuario.buscadoryoutube.PlaceHolderView;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.buscadoryoutube.POJO.MisItem;
import com.example.usuario.buscadoryoutube.R;
import com.example.usuario.buscadoryoutube.VistaLista.VistaLista;
import com.example.usuario.buscadoryoutube.VistaLista.onClickItem;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.squareup.picasso.Picasso;

@Layout(R.layout.disenio_recyclerview)
public class ItemView {

    @View(R.id.CV)
    private CardView cardView;

    @View(R.id.IV_imagen)
    private ImageView imagen;

    @View(R.id.TV_titulo)
    private TextView titulo;

    @View(R.id.TV_Canal)
    private TextView canal;

    private MisItem mInfo;
    private Context mContext;
    private Context contextVista;
    private onClickItem clickItem;

    public ItemView(Context contextVista,Context context, MisItem info) {
        contextVista=contextVista;
        mContext = context;
        mInfo = info;
        clickItem=(onClickItem)contextVista;
    }

    @Resolve
    private void onResolved()
    {
        Picasso.with(mContext).load(mInfo.getImagen()).into(imagen);
        titulo.setText(mInfo.getTitulo());
        canal.setText(mInfo.getCanal());

        cardView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                clickItem.onclickItemList(mInfo.getTitulo(),mInfo.getIdVideo());
            }
        });
    }


}
