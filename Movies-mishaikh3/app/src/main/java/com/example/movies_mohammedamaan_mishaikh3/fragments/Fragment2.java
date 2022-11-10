package com.example.movies_mohammedamaan_mishaikh3.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies_mohammedamaan_mishaikh3.R;
import com.example.movies_mohammedamaan_mishaikh3.adapters.TicketAdapter;
import com.example.movies_mohammedamaan_mishaikh3.databinding.Fragment2Binding;
import com.example.movies_mohammedamaan_mishaikh3.db.MyDatabase;
import com.example.movies_mohammedamaan_mishaikh3.models.ticket;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    private Fragment2Binding binding;
    private ArrayList<ticket> ticketList = new ArrayList<>();
    private TicketAdapter adapter;

    public Fragment2() {
        super(R.layout.fragment_2);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new TicketAdapter(this.getActivity(),ticketList);
        binding.rvTickets.setAdapter(adapter);
        binding.rvTickets.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        MyDatabase db;
        db = MyDatabase.getDatabase(this.getActivity());
        List<ticket> tick = db.ticketDAO().getAllTickets();
        if (tick.size() == 0){
            Snackbar.make(binding.getRoot(), "No Tickets Purschased", Snackbar.LENGTH_SHORT).show();
        }
        ticketList.clear();
        ticketList.addAll(tick);
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onResume(){
        super.onResume();

    }

    // lifecycle functions - required for configuring view bindings
    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = Fragment2Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
