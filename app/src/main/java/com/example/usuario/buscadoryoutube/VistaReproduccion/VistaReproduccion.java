package com.example.usuario.buscadoryoutube.VistaReproduccion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.usuario.buscadoryoutube.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VistaReproduccion extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    final String KEY="AIzaSyC4Vmj3UY_VpC_Kq8kpRyhN2-hJ-gZXp8A";
    String tituloVideo;
    String claveVideo;

    @BindView(R.id.youtube_view)
    YouTubePlayerView youtubeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_reproduccion);
        ButterKnife.bind(this);

        youtubeView.initialize(KEY,this);
        Bundle bundle = getIntent().getExtras();
        tituloVideo = bundle.getString("Titulo");
        claveVideo = bundle.getString("ClaveVideo");

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) youTubePlayer.cueVideo(claveVideo);
        else youTubePlayer.play();


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
