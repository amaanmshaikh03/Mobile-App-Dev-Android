package com.example.a3_mohammedamaan_mishaikh3.models;

import android.location.Location;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import java.io.Serializable;
import java.util.List;

public class Characters  implements Serializable {
    private int attack;
    private String category;
    private List<String> common_locations;
    private int defense;
    private String description;
    private int id;

    private String image;
    private String name;

    public int getAttack() {
        return attack;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getLocations() {
        return common_locations;
    }

    public int getDefense() {
        return defense;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "attack=" + attack +
                ", category='" + category + '\'' +
                ", locations=" + common_locations +
                ", defense=" + defense +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
