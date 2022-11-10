package com.example.a3_mohammedamaan_mishaikh3.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_mohammedamaan_mishaikh3.OnRowItemClickListener;
import com.example.a3_mohammedamaan_mishaikh3.databinding.RecyclerViewBinding;
import com.example.a3_mohammedamaan_mishaikh3.models.Characters;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ItemViewHolder> {
    private final Context context;
    private final ArrayList<Characters> itemArrayList;
    RecyclerViewBinding binding;

    public CharacterAdapter(Context context, ArrayList<Characters> items){
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
        Characters currentItem = itemArrayList.get(position);
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

        public void bind(Context context, Characters currentItem){
            // TODO: Update the UI for the row

            itemBinding.tvLine1.setText(currentItem.getName());
            itemBinding.tvLine2
                    .setText(currentItem.getDescription());

            itemBinding.tvLine3.setText(currentItem.getAttack());
            itemBinding.tvLine4.setText(currentItem.getAttack());

            // load the image
            Glide.with(context).load(currentItem.getImage()).into(itemBinding.ivCharacterPhoto);


        }
    }

}
