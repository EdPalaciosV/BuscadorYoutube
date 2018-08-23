package com.example.usuario.buscadoryoutube.RestClient;

import android.util.Log;

import com.example.usuario.buscadoryoutube.JSONResponse.Item;
import com.example.usuario.buscadoryoutube.JSONResponse.VALUES;
import com.example.usuario.buscadoryoutube.MVP.ActivityBusqueda.Callbacks;
import com.example.usuario.buscadoryoutube.POJO.MisItem;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.usuario.buscadoryoutube.RestClient.callbackRetrofit;

import java.util.ArrayList;
import java.util.List;

public class Service {

    String dato;
    final String LLAVE="AIzaSyAE2a0ti4DL-Ss3z66UgqAqAxYjhLe_XAk";

    List<MisItem> misItems;

    Callbacks.modelo modelo;

    public Service(String dato, Callbacks.modelo modelo)
    {
        this.modelo=modelo;
        this.dato=dato;
    }

    public void downloadValues()
    {
       // https://www.googleapis.com/youtube/v3/search?part=snippet&q=zoe&type=video&maxResults=20&key=AIzaSyAE2a0ti4DL-Ss3z66UgqAqAxYjhLe_XAk
        String url="https://www.googleapis.com/youtube/v3/";
        Gson gson= new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        callbackRetrofit callbackRetrofit = retrofit.create(callbackRetrofit.class);

        Observable<VALUES> observable=callbackRetrofit.getData(dato,LLAVE);

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);


    }

    Observer<VALUES> observer = new Observer<VALUES>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(VALUES value) {

            misItems =new ArrayList<>();

            for (Item item:value.getItems()) {

                misItems.add(new MisItem(item.getSnippet().getThumbnails().getHigh().getUrl(),
                        item.getSnippet().getTitle(),item.getSnippet().getChannelTitle(),item.getId().getVideoId()));

            }



        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

            modelo.passData(misItems);
        }
    };
}
