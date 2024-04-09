package org.supermarket.Entities.Days;

import org.supermarket.Entities.Purchases.Purchase;

import java.util.ArrayList;
import java.util.Date;

public class Day {

    private ArrayList<Purchase> purchases = new ArrayList<>();

    public Day(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public Double calcDayTotal() {
        Double total = 0.0;
        for(Purchase p: this.purchases) total += p.calcTotal();
        return total;
    }

    @Override
    public String toString() {
        return "Day: "+ new Date() +" total = $" + this.calcDayTotal();
    }
}


