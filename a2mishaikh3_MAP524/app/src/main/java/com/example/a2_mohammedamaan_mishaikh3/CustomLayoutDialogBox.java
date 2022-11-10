package com.example.a2_mohammedamaan_mishaikh3;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.a2_mohammedamaan_mishaikh3.databinding.CustomDialogLayoutBinding;
import java.util.ArrayList;
public class CustomLayoutDialogBox extends DialogFragment {
    String name;
    double amount;
    String AmountAsString;
    boolean paid;
    private CustomDialogLayoutBinding binding;
    private CustomLayoutDialogBoxListener listener;
    ArrayList<Purchase> purchaseList = PurchaseObjectAdapter.getList();
    public CustomLayoutDialogBox(Purchase purchaseList) {
        this.name = purchaseList.getName();
        this.amount = purchaseList.getAmount();
        AmountAsString = String.valueOf(amount);
        this.paid= purchaseList.isPaid();
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = CustomDialogLayoutBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot());
        binding.etNameTemp.setText(name);
            binding.etAmountTemp.setText(AmountAsString);
            binding.cbPaidTemp.setChecked(paid);
        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String temp_name = binding.etNameTemp.getText().toString();
                String temp_amount = binding.etAmountTemp.getText().toString();
                boolean temp_paid = binding.cbPaidTemp.isChecked();
                if(!temp_amount.isEmpty() && !temp_name.isEmpty()){
                        double amountAsDoubleUI = Double.parseDouble(temp_amount);
                        Purchase newPurchase = new Purchase(temp_name, amountAsDoubleUI, temp_paid);
                        listener.onPositiveButtonPressed(newPurchase);
                }else{
                    listener.onNegativeButtonPressed();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onNegativeButtonPressed();
            }
        });
        return builder.create();
    }
   public interface CustomLayoutDialogBoxListener {
       public void onPositiveButtonPressed(Purchase p);
       public void onNegativeButtonPressed();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (CustomLayoutDialogBoxListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
