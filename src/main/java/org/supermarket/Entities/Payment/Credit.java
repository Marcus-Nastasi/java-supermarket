package org.supermarket.Entities.Payment;

import java.util.ArrayList;

public class Credit extends Payment {

    private Double value;
    private String name, number;
    private int cvv;

    public Credit(ArrayList<String> dados, Double value, String name, String number, int cvv) {
        super(dados);
        this.value = value;
        this.name = name;
        this.number = number;
        this.cvv = cvv;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getCvv() {
        return cvv;
    }

    public void pay() {
        System.out.println("Paymeny sucesfully done.");
    }
}

