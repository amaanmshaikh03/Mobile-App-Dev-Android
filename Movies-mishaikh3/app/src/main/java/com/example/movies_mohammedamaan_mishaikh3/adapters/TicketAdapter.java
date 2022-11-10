package com.example.movies_mohammedamaan_mishaikh3.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movies_mohammedamaan_mishaikh3.databinding.TicketDetailsBinding;
import com.example.movies_mohammedamaan_mishaikh3.db.MyDatabase;
import com.example.movies_mohammedamaan_mishaikh3.models.ticket;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ItemViewHolder> {
    private final Context context;
    private final ArrayList<ticket> ticketList;
    TicketDetailsBinding binding;
    // click listener
    public TicketAdapter(Context context, ArrayList<ticket> items){
        this.ticketList = items;
        this.context = context;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(TicketDetailsBinding.inflate(LayoutInflater.from(context), parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ticket currentItem = ticketList.get(position);
        holder.bind(context, currentItem);
    }

    @Override
    public int getItemCount() {
        Log.d("ItemAdapter", "getItemCount: Number of items " +this.ticketList.size() );
        return this.ticketList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        TicketDetailsBinding itemBinding;

        public ItemViewHolder(TicketDetailsBinding binding){
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        public void bind(Context context, ticket currentItem){
            MyDatabase db;
            db = MyDatabase.getDatabase(context.getApplicationContext());
            itemBinding.tvMovieName.setText(currentItem.getMovieName());
            itemBinding.tvAmount.setText("Tickets purchased: " + currentItem.getNoOfTickets());

            itemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.ticketDAO().deleteTicket(currentItem);
                    Snackbar snack = Snackbar.make(v, "Deleted ticket purchase for " + currentItem.getMovieName(), Snackbar.LENGTH_SHORT);
                    snack.show();
                }

            });
        }
    }
}
