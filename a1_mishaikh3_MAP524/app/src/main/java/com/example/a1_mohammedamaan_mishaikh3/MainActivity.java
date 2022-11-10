/*
Name: Mohammedamaan Shaikh
ID: 157304197
mishaikh3@myseneca.ca
MAP524 NSA Assignment1
 */
package com.example.a1_mohammedamaan_mishaikh3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1_mohammedamaan_mishaikh3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ABC", "Calculate was pressed");

                binding.tvResults.setVisibility(View.GONE);
                EditText morn = binding.etMorning;
                String morntemp = morn.getText().toString();
                double morning = Double.parseDouble(morntemp);

                EditText aft = binding.etAfternoon;
                String afttemp = aft.getText().toString();
                double afternoon = Double.parseDouble(afttemp);

                EditText eve = binding.etEvening;
                String evetemp = eve.getText().toString();
                double evening = Double.parseDouble(evetemp);

                Calculate calculate = new Calculate(morning, afternoon, evening, binding.swUsesrenewable.isChecked());

                Log.d("ABC", calculate.toString());

                binding.tvResults.setText(calculate.toString());
                binding.tvResults.setVisibility(View.VISIBLE);

            }

        });

         binding.btnReset.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.d("ABC", "Reset was pressed");

                 binding.etMorning.setText(null);
                 binding.etAfternoon.setText(null);
                 binding.etEvening.setText(null);
                 binding.swUsesrenewable.setChecked(false);
                 binding.tvResults.setText(null);
             }
         });

    }
}