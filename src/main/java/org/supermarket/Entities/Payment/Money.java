package org.supermarket.Entities.Payment;

import java.util.ArrayList;

public class Money extends Payment {

    private Double value;

    public Money(ArrayList<String> dados, Double value) {
        super(dados);
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void pay() {
        System.out.println("Payment sucesfully done.");
    }
}
