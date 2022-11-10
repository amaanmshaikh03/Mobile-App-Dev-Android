package com.example.movies_mohammedamaan_mishaikh3.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movies_mohammedamaan_mishaikh3.databinding.RowLayoutBinding;
import com.example.movies_mohammedamaan_mishaikh3.models.movie;
import com.example.movies_mohammedamaan_mishaikh3.db.MyDatabase;
import com.example.movies_mohammedamaan_mishaikh3.db.TicketDAO;
import com.example.movies_mohammedamaan_mishaikh3.models.ticket;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Date;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private final Context context;
    private final ArrayList<movie> itemArrayList;
    RowLayoutBinding binding;

    public ItemAdapter(Context context, ArrayList<movie> items){
        this.itemArrayList = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        movie currentItem = itemArrayList.get(position);
        holder.bind(context, currentItem);
    }

    @Override
    public int getItemCount() {
        Log.d("ItemAdapter", "getItemCount: Number of items " +this.itemArrayList.size() );
        return this.itemArrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        RowLayoutBinding itemBinding;

        public ItemViewHolder(RowLayoutBinding binding){
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        public void bind(Context context, movie currentItem){
            MyDatabase db;
            db = MyDatabase.getDatabase(context.getApplicationContext());
            // TODO: Write the code to update recycler view's row layout
            itemBinding.tvName.setText(currentItem.getOriginal_title());
            int rate = (int)Math.round(10 * currentItem.getVote_average());
            itemBinding.tvRate.setText((Integer.toString(rate)) + "%");
            itemBinding.tvDesc.setText(currentItem.getOverview());
            itemBinding.tvReleaseDate.setText("Release Date: " + currentItem.getRelease_date());
            Glide.with(context).load(currentItem.getImg()).into(itemBinding.ivPhoto);
            itemBinding.btnTicket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String movie = currentItem.getOriginal_title();
                    int id = currentItem.getId();
                    ticket currentTicket = db.ticketDAO().getTicketById(id);
                    if(currentTicket == null){
                        db.ticketDAO().insertTicket(new ticket(movie, 1, id));
                    } else{
                        currentTicket.purchased();
                        db.ticketDAO().updateTicket(currentTicket);
                    }
                    Snackbar snack = Snackbar.make(v, "Ticket purchased for " + currentItem.getOriginal_title(),  Snackbar.LENGTH_SHORT);
                    snack.show();
                }
            });
        }
    }
}

