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

        sb.append("----- Supermarket LTDA. -----\n").append("-----------------------------\n")
        .append("        CUPOM FISCAL\n").append("-----------------------------\n")
        .append(this.date).append("\n-----------------------------\n")
        .append(this.client.getName()).append(", \n").append(this.client.getEmail()).append(", \n")
        .append(this.client.getCpf()).append("\n-----------------------------\n")
        .append("            Items \n");

        for(BuyedIten bi: this.buyedIten) {
            sb.append(bi.getProduct().getDescription())
            .append(", qnt. ").append(bi.getQuantity())
            .append(", sub. $").append(bi.calcSubTotal())
            .append(", tax. ").append(bi.getProduct().getTax() * 100).append("%\n");
        }

        sb.append("-----------------------------\n").append("Total: $")
        .append(String.format("%.2f%n", this.calcTotal()));

        return sb.toString();
    }
}
