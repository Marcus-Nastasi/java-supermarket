package org.supermarket.Entities.Payment;

public class Money extends Payment {

    private Double value;

    public Money(String[] dados, Double value) {
        super(dados);
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void pay() {
        System.out.println("Payment sucesfully done.");
    }
}
