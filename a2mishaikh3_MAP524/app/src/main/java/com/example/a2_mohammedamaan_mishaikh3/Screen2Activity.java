package com.example.a2_mohammedamaan_mishaikh3;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2_mohammedamaan_mishaikh3.databinding.ActivityScreen2Binding;
import java.util.ArrayList;
public class Screen2Activity extends AppCompatActivity implements CustomLayoutDialogBox.CustomLayoutDialogBoxListener{
    int change_index = 0;
    ArrayList<Purchase> purchaseList = PurchaseObjectAdapter.getList();
    private ActivityScreen2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScreen2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PurchaseObjectAdapter purchaseAdapter = new PurchaseObjectAdapter(this, purchaseList);
        binding.lvPurchases.setAdapter(purchaseAdapter);
        binding.lvPurchases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CustomLayoutDialogBox myCustomBox = new CustomLayoutDialogBox(purchaseList.get(i));
                myCustomBox.show(getSupportFragmentManager(), "custom layout box");
                change_index = i;

            }
        });
    }
        @Override
        public void onPositiveButtonPressed(Purchase updated) {
            purchaseList.set(change_index, updated);
            setContentView(binding.getRoot());
            PurchaseObjectAdapter purchaseAdapter = new PurchaseObjectAdapter(this, purchaseList);
            binding.lvPurchases.setAdapter(purchaseAdapter);
            Context context = getApplicationContext();
            CharSequence text = "Purchase Updated";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        @Override
    public void onNegativeButtonPressed(){
            Context context = getApplicationContext();
            CharSequence text = "Not Updated";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
}