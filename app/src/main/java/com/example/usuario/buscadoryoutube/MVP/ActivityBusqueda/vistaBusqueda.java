package com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;

import com.example.usuario.buscadoryoutube.DI.IDActivityBuscar.BusquedaApplication;
import com.example.usuario.buscadoryoutube.POJO.MisItem;
import com.example.usuario.buscadoryoutube.R;
import com.example.usuario.buscadoryoutube.VistaLista.VistaLista;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class vistaBusqueda extends AppCompatActivity implements Callbacks.vista  {

    @BindView(R.id.SV_buscar)
    SearchView SVBuscar;
    final String  BUSCAR="dato";
    Context context=this;
    String titulo;
    @Inject
    PresentadorBusqueda presentadorBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_busqueda);
        ButterKnife.bind(this);
        buscar(SVBuscar);

        ((BusquedaApplication)getApplication()).getBusquedaComponent().inject(this);


    }

    public void buscar(SearchView busqueda)
    {
        busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String dato) {

               presentadorBusqueda.Request(dato, getApplication(), (Callbacks.vista) context);
               titulo=dato;
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public void showErrorMessage(String error) {

    }

    @Override
    public void passData(List<MisItem> misItems) {


        Intent intent =new Intent(this, VistaLista.class);

        Bundle bundle =new Bundle();
        bundle.putString("Titulo",titulo);
        bundle.putParcelableArrayList("Values", (ArrayList<? extends Parcelable>) misItems);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
