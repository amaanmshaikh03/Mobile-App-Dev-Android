package com.example.t1_mohammedamaan_mishaikh3.singleton;
import java.util.ArrayList;
public class PokemonManagerSingleton {
    private PokemonManagerSingleton(){
        loadPokemonDataSet();
    }
    private static PokemonManagerSingleton instance = null;
    public static PokemonManagerSingleton getInstance(){
        if(instance == null){
            instance = new PokemonManagerSingleton();
        }
        return instance;
    }
    private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();

    private void loadPokemonDataSet() {
        this.pokemonList.add(new Pokemon(12, "Caterpie"));
        this.pokemonList.add(new Pokemon(19, "Rattata"));
        this.pokemonList.add(new Pokemon(25, "Pikachu"));
        this.pokemonList.add(new Pokemon(147, "Dratini"));
    }
    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }
    public Pokemon getPokemonById(int productId) {
        for (int i = 0; i < this.pokemonList.size(); i++) {
            Pokemon currPokemon = this.pokemonList.get(i);
            if (currPokemon.getPokemonNumber() == productId) {
                return currPokemon;
            }
        }
        return null;
    }
    public int size() {
        return pokemonList.size();
    }
    public Pokemon get(int position) {
        return pokemonList.get(position);
    }
}
