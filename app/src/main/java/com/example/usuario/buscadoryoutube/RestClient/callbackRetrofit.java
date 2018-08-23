package com.example.usuario.buscadoryoutube.RestClient;

import com.example.usuario.buscadoryoutube.JSONResponse.VALUES;

import io.reactivex.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface callbackRetrofit {

    //search?part=snippet&q=zoe&type=video&maxResults=20&key=AIzaSyAE2a0ti4DL-Ss3z66UgqAqAxYjhLe_XAk
    @GET("search?part=snippet&&type=video&maxResults=20&")
    //Call<VALUES> getData(@Query("q") String dato,@Query("key") String key);
    Observable<VALUES> getData(@Query("q") String dato,@Query("key") String key);
}
