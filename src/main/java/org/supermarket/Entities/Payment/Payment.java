package org.supermarket.Entities.Payment;

import java.util.ArrayList;

public abstract class Payment {

    private ArrayList<String> dados = new ArrayList<>();
    private Double value;

    public Payment(ArrayList<String> dados) {
        this.dados = dados;
    }

    public ArrayList<String> getDados() {
        return dados;
    }
    public void setDados(ArrayList<String> dados) {
        this.dados = dados;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public abstract void pay();
}

