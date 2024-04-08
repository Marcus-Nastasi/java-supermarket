package org.supermarket.Entities.Payment;

public abstract class Payment {

    private String[] dados;

    public Payment(String[] dados) {
        this.dados = dados;
    }

    public String[] getDados() {
        return dados;
    }
    public void setDados(String[] dados) {
        this.dados = dados;
    }

    public abstract void pay();
}

