package org.supermarket.Entities.UIs;

import org.supermarket.Controllers.Stock.StockController;
import org.supermarket.Entities.BuyItens.BuyedIten;
import org.supermarket.Entities.Clients.Client;
import org.supermarket.Entities.Payment.Payment;
import org.supermarket.Entities.Stock.Stock;

import java.util.ArrayList;

public class UI {

    private final Stock stock = new Stock();
    private final StockController stockController = new StockController(stock);
    private ArrayList<BuyedIten> buyedItens;
    private Payment payment;
    private Client client;

    public UI(ArrayList<BuyedIten> buyedItens, Payment payment, Client client) {
        this.buyedItens = buyedItens;
        this.payment = payment;
        this.client = client;
    }

    public Stock getStock() {
        return stock;
    }

    public StockController getStockController() {
        return stockController;
    }

    public ArrayList<BuyedIten> getBuyedItens() {
        return buyedItens;
    }

    public Payment getPayment() {
        return payment;
    }

    public Client getClient() {
        return client;
    }
}
