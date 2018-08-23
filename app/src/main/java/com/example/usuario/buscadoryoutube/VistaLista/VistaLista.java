package com.example.usuario.buscadoryoutube.VistaLista;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.usuario.buscadoryoutube.Adapters.AdapterItems;
import com.example.usuario.buscadoryoutube.POJO.MisItem;
import com.example.usuario.buscadoryoutube.PlaceHolderView.ItemView;
import com.example.usuario.buscadoryoutube.PlaceHolderView.LoadMoreView;
import com.example.usuario.buscadoryoutube.R;
import com.example.usuario.buscadoryoutube.VistaReproduccion.VistaReproduccion;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VistaLista extends AppCompatActivity implements onClickItem{

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    String tituloToolbar;

    List<MisItem> items;
    private InfinitePlaceHolderView mLoadMoreView;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_lista);
        ButterKnife.bind(this);
        configurationToolbar(toolbar);
        items=getIntent().getParcelableArrayListExtra("Values");

        mLoadMoreView=(InfinitePlaceHolderView)findViewById(R.id.loadMoreView);

        //putItemsAdapter(items);
        setupView();


    }
    public void configurationToolbar(Toolbar toolbar)
    {
        tituloToolbar=getIntent().getExtras().getString("Titulo");
        toolbar.setTitle(tituloToolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
    }

    private void setupView()
    {
        for (int i=0; i< LoadMoreView.LOAD_VIEW_SET_COUNT;i++)
        {
            mLoadMoreView.addView(new ItemView(context,this.getApplicationContext(),items.get(i)));
        }
        mLoadMoreView.setLoadMoreResolver(new LoadMoreView(context,mLoadMoreView,items));
    }
    public void putItemsAdapter(List<MisItem> items){

       /* RVLista.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RVLista.setLayoutManager(layoutManager);

        AdapterItems adapterItems=new AdapterItems(this,items);

        RVLista.setAdapter(adapterItems);*/




    }

    @Override
    public void onclickItemList(String titulo,String idVideo) {

        Intent intent =new Intent(this, VistaReproduccion.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("ClaveVideo",idVideo);

        startActivity(intent);

    }
}
