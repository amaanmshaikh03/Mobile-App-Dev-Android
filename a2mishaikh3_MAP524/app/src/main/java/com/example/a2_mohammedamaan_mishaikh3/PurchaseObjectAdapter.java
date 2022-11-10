package com.example.a2_mohammedamaan_mishaikh3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.a2_mohammedamaan_mishaikh3.databinding.CustomRowLayoutBinding;
import java.util.ArrayList;
public class PurchaseObjectAdapter extends ArrayAdapter {
    private static ArrayList<Purchase> purchaseList;
    public PurchaseObjectAdapter(@NonNull Context context, ArrayList<Purchase> purchaseList) {
        super(context, 0);
        this.purchaseList = purchaseList;
    }
    public static ArrayList<Purchase> getList() {
        return purchaseList;
    }
    @Override
    public int getCount() {
        return purchaseList.size();
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row_layout, parent, false);
        }
        Purchase currPurchase = purchaseList.get(position);
        CustomRowLayoutBinding binding = CustomRowLayoutBinding.bind(convertView);
        binding.tvPurchaseName.setText(currPurchase.getName());
        binding.tvPurchaseAmount.setText(String.valueOf(currPurchase.getAmount()));
        if (currPurchase.isPaid()){
            binding.tvPurchasePaid.setText("Paid");
        }else{
            binding.tvPurchasePaid.setText("Not Paid");
        }
        return convertView;
    }
}
