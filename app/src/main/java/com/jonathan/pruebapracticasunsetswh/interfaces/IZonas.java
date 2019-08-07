package com.jonathan.pruebapracticasunsetswh.interfaces;

import com.jonathan.pruebapracticasunsetswh.modelo.ElementoZonas;
import com.jonathan.pruebapracticasunsetswh.modelo.Zonas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IZonas {
    @GET("/estado")
    Call<ElementoZonas> getZonas();
}
