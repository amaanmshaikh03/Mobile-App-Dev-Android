package com.example.a3_mohammedamaan_mishaikh3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.a3_mohammedamaan_mishaikh3.adapters.CharacterAdapter;
import com.example.a3_mohammedamaan_mishaikh3.databinding.ActivityMainBinding;
import com.example.a3_mohammedamaan_mishaikh3.models.CharacterResponseObject;
import com.example.a3_mohammedamaan_mishaikh3.models.Characters;
import com.example.a3_mohammedamaan_mishaikh3.network.API;
import com.example.a3_mohammedamaan_mishaikh3.network.RetrofitClient;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    private final String TAG="A3";
    // binding
    private ActivityMainBinding binding;
    private ArrayList<Characters> itemsList = new ArrayList<Characters>();
    private CharacterAdapter adapter;
    // api
    private API api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        // configure the recyclerview
        adapter = new CharacterAdapter(this, itemsList);
        binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItems.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        binding.rvItems.setAdapter(adapter);


        // TODO: configure the API client
        this.api = RetrofitClient.getInstance().getApi();
        Call<CharacterResponseObject> request = this.api.getAllEquips();
        request.enqueue(new Callback<CharacterResponseObject>() {


                            @Override
                            public void onResponse(Call<CharacterResponseObject> call, Response<CharacterResponseObject> response) {

                                Log.d(TAG, "The request was successful");
                                // do whatever code you need to handle the response
                                Log.d(TAG, "Response code: " + response.code());

                                // error handling, in case something strange happens
                                if (response.isSuccessful() == false) {
                                    Log.d(TAG, "Response error: " + response.code());
                                    return;
                                }
                                Log.d(TAG, "body: " + response.body().toString());

                                // retrieve the contents of the response
                                CharacterResponseObject obj = response.body();
                                // update the class property to be whatever was returned by the response
                                List<Characters> charactersFromAPI = obj.getResults();

                                // update the recycler view
                                itemsList.clear();
                                itemsList.addAll(charactersFromAPI);
                                adapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<CharacterResponseObject> call, Throwable t) {
                                // - no internet
                                // - server down
                                Log.d(TAG, "The request failed");
                                Log.d(TAG, t.getMessage());
                            }

                        });

//
//        Log.d(TAG, "ouat ");
//        // configure search button handler
//        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "in ");
//
//                // get search key from UI
//                String charNameFromUI = binding.etCharacterName.getText().toString();
//                if (charNameFromUI.isEmpty() == true) {
//                    Snackbar.make(binding.getRoot(), "Please enter a search term", Snackbar.LENGTH_SHORT).show();
//                    return;
//                }
//
//                // TODO: Start the search
//
//
//                Call<CharacterResponseObject> request = api.getOneCharacterByName(charNameFromUI);
//                request.enqueue(new Callback<CharacterResponseObject>() {
//
//
//                    @Override
//                    public void onResponse(Call<CharacterResponseObject> call, Response<CharacterResponseObject> response) {
//
//                        Log.d(TAG, "The request was successful");
//                        // do whatever code you need to handle the response
//                        Log.d(TAG, "Response code: " + response.code());
//
//                        // error handling, in case something strange happens
//                        if (response.isSuccessful() == false) {
//                            Log.d(TAG, "Response error: " +  response.code());
//                            return;
//                        }
//                        Log.d(TAG, "body: " + response.body().toString());
//
//                        // retrieve the contents of the response
//                        CharacterResponseObject obj = response.body();
//                        // update the class property to be whatever was returned by the response
//                        charactersFromAPI = obj.getResults();
//
//                        // update the recycler view
//                        itemsList.clear();
//                        itemsList.addAll(charactersFromAPI);
//                        adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onFailure(Call<CharacterResponseObject> call, Throwable t) {
//                        Log.d(TAG, t.getMessage());
//                    }
//                });
//
//
//            }
//        });
    }


}