package com.example.a3_mohammedamaan_mishaikh3.network;



import com.example.a3_mohammedamaan_mishaikh3.models.CharacterResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// interface that retrofit will use to connect to the api endpoints
public interface API {
    // TODO: base url of the api
    public final String BASE_URL = "https://botw-compendium.herokuapp.com/api/v2/";

    // TODO: endpoints we want to connect to
    // https://rickandmortyapi.com/api/character/?name=president
    @GET("category/equipment")
//    public Call<CharacterResponseObject> getOneCharacterByName(@Query("name") String searchTerm);
    public Call<CharacterResponseObject> getAllEquips();
}