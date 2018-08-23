package com.example.usuario.buscadoryoutube.DI.IDActivityBuscar;

import com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda.PresentadorBusqueda;
import com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda.vistaBusqueda;

import dagger.Component;


@Component(modules = {BusquedaModulo.class})
public interface BusquedaComponent {

    void inject(vistaBusqueda vistaBusqueda);
    void injectPresenter(PresentadorBusqueda presentadorBusqueda);
}
