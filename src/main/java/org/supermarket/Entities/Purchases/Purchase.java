package org.supermarket.Entities.Purchases;

import org.supermarket.Entities.BuyItens.BuyedIten;
import org.supermarket.Entities.Clients.Client;
import org.supermarket.Entities.Payment.Payment;
import org.supermarket.Exceptions.PurchaseException;

import java.util.ArrayList;
import java.util.Date;

public class Purchase {

    private final Client client;
    private final String date = new Date().toString();
    private final ArrayList<BuyedIten> buyedIten;
    private Payment payment;

    public Purchase(Client client, ArrayList<BuyedIten> buyedIten, Payment payment) throws PurchaseException {
        if(buyedIten.isEmpty()) throw new PurchaseException("No itens on your purchase.");
        if(client == null) throw new PurchaseException("No client associated.");
        if(payment == null) throw new PurchaseException("No payment chose");
        this.client = client;
        this.buyedIten = buyedIten;
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<BuyedIten> getBuyedItens() {
        return buyedIten;
    }

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double calcTotal() {
        Double total = 0.0;
        for(BuyedIten bi: this.buyedIten) total += bi.calcSubTotal();
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("--------- Supermarket LTDA. ---------\n")
        .append("-------------------------------------\n")
        .append("           CUPOM FISCAL\n")
        .append("-------------------------------------\n").append(getDate())
        .append("\n-------------------------------------\n").append(client)
        .append("-------------------------------------\n")
        .append("               Items \n");

        for(BuyedIten bi: buyedIten) {
            sb.append(bi.getProduct().getDescription())
            .append(", qnt. ").append(bi.getQuantity())
            .append(", sub. $").append(String.format("%.2f", bi.calcSubTotal()))
            .append(", tax. ").append(String.format("%.2f", bi.getProduct().getTax() * 100))
            .append("%\n");
        }

        sb.append("-------------------------------------\n")
        .append("Total: $").append(String.format("%.2f%n", calcTotal()));

        return sb.toString();
    }
}


