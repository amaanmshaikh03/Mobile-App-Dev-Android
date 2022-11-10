package com.example.movies_mohammedamaan_mishaikh3.models;


import com.google.gson.annotations.SerializedName;

import java.util.Date;
public class movie {
    private String original_title;
    private String overview;
    private String release_date;
    private int id;

    @SerializedName("poster_path")
    private String img;
    private double vote_average;
    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return "https://image.tmdb.org/t/p/w500/" + img;
    }

    public double getVote_average() {
        return vote_average;
    }
}

