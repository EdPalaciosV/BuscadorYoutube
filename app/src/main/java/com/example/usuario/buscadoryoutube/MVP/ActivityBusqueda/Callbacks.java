package com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda;

import android.app.Application;

import com.example.usuario.buscadoryoutube.POJO.MisItem;

import java.util.List;

public interface Callbacks {

    interface vista{

        void showErrorMessage(String error);
        void passData(List<MisItem> misItems);
    }

    interface presenter
    {
        void Request(String value, Application application,Callbacks.vista vista);
        void passData(List<MisItem> misItems);

    }

    interface modelo{

        void Request(String value, Application application,Callbacks.presenter presenter);
        void passData(List<MisItem> misItems);
    }


}
