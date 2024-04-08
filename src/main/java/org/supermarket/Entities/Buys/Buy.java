package org.supermarket.Entities.Buys;

import org.supermarket.Entities.BuyItens.BuyedItens;
import org.supermarket.Entities.Clients.Client;
import org.supermarket.Entities.Payment.Payment;
import org.supermarket.Exceptions.BuyException;

import java.util.ArrayList;
import java.util.Date;

public class Buy {

    private final Client client;
    private final String date = new Date().toString();
    private final ArrayList<BuyedItens> buyedItens;
    private Payment payment;

    public Buy(Client client, ArrayList<BuyedItens> buyedItens, Payment payment) throws BuyException {
        if(buyedItens.isEmpty()) throw new BuyException("No itens on your purchase.");
        this.client = client;
        this.buyedItens = buyedItens;
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<BuyedItens> getBuyedItens() {
        return buyedItens;
    }

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double calcTotal() {
        Double total = 0.0;
        for(BuyedItens bi: this.buyedItens) total += bi.calcSubTotal();
        return total;
    }
}

