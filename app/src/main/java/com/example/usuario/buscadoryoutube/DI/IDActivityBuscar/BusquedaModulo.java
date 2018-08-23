package com.example.usuario.buscadoryoutube.DI.IDActivityBuscar;


import com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda.ModeloBusqueda;
import com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda.PresentadorBusqueda;

import dagger.Module;
import dagger.Provides;

@Module
public class BusquedaModulo {

    @Provides
    public PresentadorBusqueda presentador()
    {
        return new PresentadorBusqueda();
    }

    @Provides
    public ModeloBusqueda modelo()
    {
        return new ModeloBusqueda();
    }

}
