package com.example.movies_mohammedamaan_mishaikh3.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName="ticket_table")
public class ticket {
    private String movieName;
    private int noOfTickets;
    @PrimaryKey
    private int id;

    public ticket(String movieName, int noOfTickets, int id) {
        this.movieName = movieName;
        this.noOfTickets = noOfTickets;
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void purchased(){
        this.noOfTickets++;
    }
}
