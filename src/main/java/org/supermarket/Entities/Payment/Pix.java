package org.supermarket.Entities.Payment;

import java.util.ArrayList;

public class Pix extends Payment {

    private Double value;
    private String pixKey;

    public Pix(ArrayList<String> dados, Double value, String pixKey) {
        super(dados);
        this.value = value;
        this.pixKey = pixKey;
    }

    public Double getValue() {
        return value;
    }

    public String getPixKey() {
        return pixKey;
    }

    public void pay() {
        System.out.println("Paymeny sucesfully done.");
    }
}

