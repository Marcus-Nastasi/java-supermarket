package org.supermarket.Entities.Days;

import org.supermarket.Entities.Buys.Buy;

import java.util.ArrayList;

public class Day {

    private ArrayList<Buy> buys = new ArrayList<>();

    public Day(ArrayList<Buy> buys) {
        this.buys = buys;
    }

    public ArrayList<Buy> getBuys() {
        return buys;
    }

    public Double calcDayTotal() {
        Double total = 0.0;
        for(Buy b: this.buys) total += b.calcTotal();
        return total;
    }
}


