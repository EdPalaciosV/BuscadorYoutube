package com.example.usuario.buscadoryoutube.DI.IDActivityBuscar;

import android.app.Application;

public class BusquedaApplication  extends Application{

    private BusquedaComponent busquedaComponent;

    public BusquedaComponent getBusquedaComponent() {
        busquedaComponent=DaggerBusquedaComponent.builder().busquedaModulo(new BusquedaModulo()).build();
        return busquedaComponent;
    }
}
