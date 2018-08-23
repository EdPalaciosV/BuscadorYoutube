package com.example.usuario.buscadoryoutube.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class MisItem  implements Parcelable{

    String imagen;
    String titulo;
    String canal;
    String idVideo;

    public MisItem(String imagen, String titulo, String canal,String idVideo) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.canal = canal;
        this.idVideo=idVideo;
    }

    protected MisItem(Parcel in) {
        imagen = in.readString();
        titulo = in.readString();
        canal = in.readString();
        idVideo = in.readString();
    }

    public static final Creator<MisItem> CREATOR = new Creator<MisItem>() {
        @Override
        public MisItem createFromParcel(Parcel in) {
            return new MisItem(in);
        }

        @Override
        public MisItem[] newArray(int size) {
            return new MisItem[size];
        }
    };

    public String getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCanal() {
        return canal;
    }

    public String getIdVideo()
    {
        return idVideo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imagen);
        parcel.writeString(titulo);
        parcel.writeString(canal);
        parcel.writeString(idVideo);
    }
}
