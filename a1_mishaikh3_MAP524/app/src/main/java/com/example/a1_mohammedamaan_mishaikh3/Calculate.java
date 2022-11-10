/*
Name: Mohammedamaan Shaikh
ID: 157304197
mishaikh3@myseneca.ca
MAP524 NSA Assignment1
 */
package com.example.a1_mohammedamaan_mishaikh3;
import java.text.DecimalFormat;
public class Calculate {
    private double mpay = 0;
    private double apay = 0;
    private double epay = 0;
    private double subtotal = 0;
    private double tax = 0;
    private double deduct = 0;
    private double taxanddeduct = 0;
    private double total = 0;
    private static final DecimalFormat df = new DecimalFormat("0.00");
public Calculate( double mkwh, double akwh, double ekwh, boolean ok){
    this.mpay = mkwh * 0.132;
    this.apay = akwh * 0.065;
    this.epay = ekwh * 0.094;
    this.subtotal =  this.mpay + this.apay + this.epay;
    this.tax = 0.13 * this.subtotal;
    if(ok == true){
        this.deduct = 0.08 * this.subtotal;
    }else{
        this.deduct = 0;
    }
    this.taxanddeduct = this.tax - this.deduct;
    this.total = this.subtotal + this.taxanddeduct;
}
public String toString(){
    return "Charges Breakdown: " + "\n"
            + "Morning Charges: $" + df.format(this.mpay) + "\n"
            + "Afternoon Charges: $" + df.format(this.apay) + "\n"
            + "Evening Charges: $" + df.format(this.epay) + "\n"
            +  "Total Charges: $" + df.format(this.subtotal) + "\n"
            + "Taxes: $" + df.format(this.tax) + "\n"
            + "Environmental rebate: -$" + df.format(this.deduct) + "\n"
            + "Total Regulatory Bill: $" + df.format(this.taxanddeduct) + "\n"
            + "Total Bill Amount: $" + df.format(this.total);
}
}
