package com.example.a3_mohammedamaan_mishaikh3.adapters;


import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_mohammedamaan_mishaikh3.databinding.RecyclerViewBinding;


import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ItemViewHolder> {
    private final Context context;
    private final ArrayList<String> itemArrayList;
    RecyclerViewBinding binding;

    public LocationAdapter(Context context, ArrayList<String> items){
        this.itemArrayList = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(RecyclerViewBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String currentItem = itemArrayList.get(position);
       // holder.bind(context, currentItem);
    }

    @Override
    public int getItemCount() {
        Log.d("CharacterAdapter", "getItemCount: Number of items " +this.itemArrayList.size() );
        return this.itemArrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        RecyclerViewBinding itemBinding;

        public ItemViewHolder(RecyclerViewBinding binding){
            super(binding.getRoot());
            this.itemBinding = binding;
        }
    }

}
