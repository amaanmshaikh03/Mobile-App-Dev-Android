package com.example.movies_mohammedamaan_mishaikh3.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies_mohammedamaan_mishaikh3.R;
import com.example.movies_mohammedamaan_mishaikh3.adapters.ItemAdapter;
import com.example.movies_mohammedamaan_mishaikh3.databinding.ActivityMainBinding;
import com.example.movies_mohammedamaan_mishaikh3.databinding.Fragment1Binding;
import com.example.movies_mohammedamaan_mishaikh3.models.CharacterResponseObject;
import com.example.movies_mohammedamaan_mishaikh3.models.movie;
import com.example.movies_mohammedamaan_mishaikh3.network.API;
import com.example.movies_mohammedamaan_mishaikh3.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Fragment1 extends Fragment {
    private Fragment1Binding binding;
    private final String TAG="APIDEMO";
    private ArrayList<movie> itemsList = new ArrayList<>();
    private ItemAdapter adapter;
    private API api;
    private List<movie> charactersFromAPI = new ArrayList<>();
    public Fragment1() {
        super(R.layout.fragment_1);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.api = RetrofitClient.getInstance().getApi();
        adapter = new ItemAdapter(this.getActivity(), itemsList);
        binding.rvItems.setAdapter(adapter);
        binding.rvItems.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        Call<CharacterResponseObject> request = this.api.getAllMovies();
        request.enqueue(new Callback<CharacterResponseObject>() {
            @Override
            public void onResponse(Call<CharacterResponseObject> call, Response<CharacterResponseObject> response) {
                Log.d(TAG, "The request was successful");
                // do whatever code you need to handle the response
                Log.d(TAG, "Response code: " + response.code());

                // error handling, in case something strange happens
                if (response.isSuccessful() == false) {
                    Log.d(TAG, "Response error: " +  response.code());
                    return;
                }

                // otherwise everything was okay and we can get the contents of the response
                CharacterResponseObject obj = response.body();
                charactersFromAPI = obj.getResults();

                // set the data source to be the list we returned from the api
                // - or you can cast from a List to ArrayList
                itemsList.clear();
                itemsList.addAll(charactersFromAPI);
                // notify the adapter that something changed
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
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


