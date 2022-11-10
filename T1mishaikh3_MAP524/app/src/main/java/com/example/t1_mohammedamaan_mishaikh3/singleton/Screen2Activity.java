package com.example.t1_mohammedamaan_mishaikh3.singleton;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.t1_mohammedamaan_mishaikh3.R;
import com.example.t1_mohammedamaan_mishaikh3.databinding.Activityscreen2Binding;
import com.example.t1_mohammedamaan_mishaikh3.singleton.PokemonManagerSingleton;
import com.example.t1_mohammedamaan_mishaikh3.singleton.Pokemon;
import com.google.android.material.snackbar.Snackbar;
public class Screen2Activity extends AppCompatActivity {
    private Activityscreen2Binding binding;
    private SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = Activityscreen2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Intent intent = getIntent();
        int id = intent.getIntExtra("EXTRA_SELECTED_POKEMON_ID", -1);
        PokemonManagerSingleton pokemonManager = PokemonManagerSingleton.getInstance();
        Pokemon currPokemon = pokemonManager.getPokemonById(id);
        if (intent != null) {

            int img = getResources().getIdentifier(currPokemon.getName().toLowerCase(), "drawable", getPackageName());
            binding.photoImageView.setImageResource(img);
            binding.tvName.setText("Pokemon Name:" + currPokemon.getName());
            binding.tvNumber.setText("Pokedex Number:" + String.valueOf(currPokemon.getPokemonNumber()));
        }

        binding.btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random1 = (int)(Math.random()* 5) + 1;
                int random2 = (int)(Math.random()* 5) + 1;
                int a = currPokemon.getWins();
                int b = currPokemon.getLose();
                if(random1 > random2){
                    Snackbar.make(binding.getRoot(), "Pokemon:" + random1 + "Computer:" + random2 + "   Winner: Pokemon", Snackbar.LENGTH_LONG).show();
                    a++;
                }else{
                    Snackbar.make(binding.getRoot(), "Pokemon:" + random1 + "Computer:" + random2 + "   Winner: Computer", Snackbar.LENGTH_LONG).show();
                    b++;
                }
                currPokemon.setWins(a);
                currPokemon.setLose(b);
            }


        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.screen1_options_menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle the different menu options that were clicked
        switch (item.getItemId()) {
            case R.id.miSetAsFavourite:
                setasfavourite();
                return true;
            case R.id.miReset:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void reset(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("EXTRA_SELECTED_POKEMON_ID", -1);
        PokemonManagerSingleton pokemonManager = PokemonManagerSingleton.getInstance();
        Pokemon currPokemon = pokemonManager.getPokemonById(id);
        currPokemon.setWins(0);
        currPokemon.setLose(0);
        this.sp = getSharedPreferences("MY-SP", Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        spEditor.remove("KEY_"+currPokemon.getPokemonNumber());
        spEditor.commit();
        Toast.makeText(getApplicationContext(), currPokemon.getName() + " is reset", Toast.LENGTH_SHORT).show();
    }

    private void setasfavourite(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("EXTRA_SELECTED_POKEMON_ID", -1);
        PokemonManagerSingleton pokemonManager = PokemonManagerSingleton.getInstance();
        Pokemon currPokemon = pokemonManager.getPokemonById(id);
        Log.d("ABC", "Initialized shared preferences!");
        this.sp = getSharedPreferences("MY-SP", Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        spEditor.putString("KEY_"+currPokemon.getPokemonNumber(), currPokemon.getName());
        spEditor.apply();
        Snackbar.make(binding.getRoot(), currPokemon.getName()+" favourite marked", Snackbar.LENGTH_LONG).show();
    }
}

