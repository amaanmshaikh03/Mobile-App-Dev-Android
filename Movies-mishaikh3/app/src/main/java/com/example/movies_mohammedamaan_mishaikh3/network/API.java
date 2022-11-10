package com.example.movies_mohammedamaan_mishaikh3.network;


import com.example.movies_mohammedamaan_mishaikh3.models.CharacterResponseObject;
import com.example.movies_mohammedamaan_mishaikh3.models.movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// this api defines the base url of the api
// it defines the endpoints we want to connect to
public interface API {
    // base url of the api
    public final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    // functions: endpoints that you want to connect to
    // - ACTIONS you are using to connect to the endpoint (GET, POST, PUT, PATCH, DELETE...)
    // - Data type that is returned by the endpoint

    // connect to the get all pokemon endpoint of the api
    @GET("now_playing?api_key=da743a33fd948731737634ea207e7a44&language=en-US&page=1&region=CA")
    public Call<CharacterResponseObject> getAllMovies();

    // add additional endpoints as functions here
    // https://digimon-api.vercel.app/api/digimon/name/Agumon
//    @GET("digimon/name/Agumon")
//    public Call<List<Digimon>> getAgumon();
//
//    @GET("digimon/name/{name}")
//    public Call<List<Digimon>> getDigimonByName(@Path("name") String digimonName);

}
