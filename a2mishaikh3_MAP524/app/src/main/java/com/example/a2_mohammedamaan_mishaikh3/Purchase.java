package com.example.a2_mohammedamaan_mishaikh3;
public class Purchase {
    public String name;
    public double amount;
    public boolean paid;

    public Purchase(String name, double amount, boolean paid) {
        this.name= name;
        this.amount = amount;
        this.paid = paid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", paid=" + paid +
                '}';
    }
}
