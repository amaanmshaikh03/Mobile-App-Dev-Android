package com.example.t1_mohammedamaan_mishaikh3.singleton;


public class Pokemon {
    private int pokemonNumber;
    private String name;
    private int wins = 0;
    private int lose = 0;

    public Pokemon(int pokemonNumber, String name) {
        this.pokemonNumber = pokemonNumber;
        this.name = name;
    }

    public int getPokemonNumber() {
        return pokemonNumber;
    }

    public void setPokemonNumber(int pokemonNumber) {
        this.pokemonNumber = pokemonNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokemonNumber=" + pokemonNumber +
                ", name='" + name + '\'' +
                ", wins=" + wins +
                ", lose=" + lose +
                '}';
    }
}
