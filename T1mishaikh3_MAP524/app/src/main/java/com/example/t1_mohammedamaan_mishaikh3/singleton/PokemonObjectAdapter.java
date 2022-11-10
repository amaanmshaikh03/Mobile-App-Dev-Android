package com.example.t1_mohammedamaan_mishaikh3.singleton;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.t1_mohammedamaan_mishaikh3.R;
import com.example.t1_mohammedamaan_mishaikh3.databinding.CustomRowLayoutBinding;
public class PokemonObjectAdapter extends ArrayAdapter {
    private static PokemonManagerSingleton pokemonList;
    private SharedPreferences sp;
    public PokemonObjectAdapter(@NonNull Context context, PokemonManagerSingleton pokemonList) {
        super(context, 0);
        this.pokemonList = pokemonList;
    }
    public static PokemonManagerSingleton getList() {
        return pokemonList;
    }
    @Override
    public int getCount() {
        return pokemonList.size();
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row_layout, parent, false);
        Pokemon currPokemon = pokemonList.get(position);
        CustomRowLayoutBinding binding = CustomRowLayoutBinding.bind(convertView);
        binding.tvPokemonName.setText(currPokemon.getName());
        binding.tvPokemonWin.setText("Wins: "+ String.valueOf(currPokemon.getWins()) + "-" + String.valueOf(currPokemon.getLose()));
        this.sp = getContext().getSharedPreferences("MY-SP", Context.MODE_PRIVATE);
        if(sp.contains("KEY_" + currPokemon.getPokemonNumber() )){
            binding.getRoot().setBackgroundColor(Color.parseColor("#FFFF00"));
        }else{
            binding.getRoot().setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return convertView;
    }
}
