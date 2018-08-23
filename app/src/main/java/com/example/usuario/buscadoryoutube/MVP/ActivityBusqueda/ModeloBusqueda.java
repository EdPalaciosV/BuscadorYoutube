package com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda;

import android.app.Application;
import android.util.Log;

import com.example.usuario.buscadoryoutube.POJO.MisItem;
import com.example.usuario.buscadoryoutube.RestClient.Service;

import java.util.List;

public class ModeloBusqueda implements Callbacks.modelo {

Callbacks.presenter presenter;
    @Override
    public void Request(String value, Application application, Callbacks.presenter presenter) {

        this.presenter=presenter;
        Service service =new Service(value,this);
        service.downloadValues();
    }

    @Override
    public void passData(List<MisItem> misItems) {


        presenter.passData(misItems);
    }
}
