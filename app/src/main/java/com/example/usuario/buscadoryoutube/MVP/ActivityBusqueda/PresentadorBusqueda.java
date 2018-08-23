package com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda;

import android.app.Application;

import com.example.usuario.buscadoryoutube.DI.IDActivityBuscar.BusquedaApplication;
import com.example.usuario.buscadoryoutube.POJO.MisItem;

import java.util.List;

import javax.inject.Inject;

public class PresentadorBusqueda implements Callbacks.presenter {

    @Inject
    ModeloBusqueda modeloBusqueda;

    Callbacks.vista vista;

    @Override
    public void Request(String value, Application application, Callbacks.vista vista) {

        this.vista=vista;
        ((BusquedaApplication)application).getBusquedaComponent().injectPresenter(this);
         modeloBusqueda.Request(value,application,this);
    }

    @Override
    public void passData(List<MisItem> misItems) {

        vista.passData(misItems);
    }
}
