package com.example.t1_mohammedamaan_mishaikh3.singleton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.t1_mohammedamaan_mishaikh3.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int count =-1;
   // private SharedPreferences sp;
    PokemonManagerSingleton pokemonManager= PokemonManagerSingleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PokemonObjectAdapter pokemonAdapter = new PokemonObjectAdapter(this, pokemonManager);
        binding.lvPokemons.setAdapter(pokemonAdapter);
        //this.sp = getSharedPreferences("MY-SP", Context.MODE_PRIVATE);
        //  spEdit.putInt("KEY_" + currPokemon.getId(), currPokemon.getId());
        //     if(this.sp.contains("KEY_25")){
        //            binding.lvPokemon.setBackgroundColor(Color.parseColor("#FFFF00"));
        //       }else {
        //    binding.lvPokemon.setBackgroundColor(Color.parseColor("#FFFFFF"));
        //  }
        binding.lvPokemons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Screen2Activity.class);
                intent.putExtra("EXTRA_SELECTED_POKEMON_ID", pokemonManager.getPokemonList().get(position).getPokemonNumber());
                startActivity(intent);
                count = position;
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        PokemonObjectAdapter pokemonAdapter = new PokemonObjectAdapter(this, pokemonManager);
        binding.lvPokemons.setAdapter(pokemonAdapter);
 //       this.sp = getSharedPreferences("MY-SP", Context.MODE_PRIVATE);
   //     if(this.sp.contains("KEY_25")){
     //       binding.lvPokemons.setBackgroundColor(Color.parseColor("#FFFF00"));
       // }else{
         //   binding.lvPokemons.setBackgroundColor(Color.parseColor("#FFFFFF"));
        //}
    }
}