package com.example.a2_mohammedamaan_mishaikh3;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2_mohammedamaan_mishaikh3.databinding.ActivityMainBinding;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ArrayList<Purchase> purchaseList =  new ArrayList<Purchase>();;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PurchaseObjectAdapter purchaseAdapter = new PurchaseObjectAdapter(this,purchaseList);
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String purchaseName = binding.etName.getText().toString();
        String amount = binding.etAmount.getText().toString();
        double amountAsDouble = Double.parseDouble(amount);
        boolean paid = binding.cdIsPaid.isChecked();
        Purchase purchaseToAdd= new Purchase(purchaseName, amountAsDouble, paid);
        purchaseList.add(purchaseToAdd);
        purchaseAdapter.notifyDataSetChanged();
        binding.cdIsPaid.setChecked(false);
        binding.etName.setText("");
        binding.etAmount.setText("");
        Context context = getApplicationContext();
        CharSequence text = purchaseToAdd.toString();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
});
binding.btnDummy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        purchaseList.add(new Purchase("Food Basics", 85.23, true));
        purchaseList.add(new Purchase("Sobey", 49.65, false));
        purchaseList.add(new Purchase("Costco", 555.55, true));
        purchaseList.add(new Purchase("Shoppers", 77.77, false));
        purchaseList.add(new Purchase("Walmart", 919.37, true));
        purchaseAdapter.notifyDataSetChanged();
        Context context = getApplicationContext();
        CharSequence text = "Dummy data loaded";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
});
        binding.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Screen2Activity.class);
                startActivity(intent);
            }
        });
    }
}