package org.supermarket.Entities.UIs;

import org.supermarket.Controllers.Clients.ClientController;
import org.supermarket.Controllers.Stock.StockController;
import org.supermarket.Entities.BuyItens.BuyedIten;
import org.supermarket.Entities.Clients.Client;
import org.supermarket.Entities.Payment.Credit;
import org.supermarket.Entities.Payment.Money;
import org.supermarket.Entities.Payment.Payment;
import org.supermarket.Entities.Payment.Pix;
import org.supermarket.Entities.Purchases.Purchase;
import org.supermarket.Entities.Stock.Stock;
import org.supermarket.Exceptions.PurchaseException;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private final Stock stock = new Stock();
    private final StockController stockController = new StockController(stock);
    private final ClientController clientController = new ClientController();
    private ArrayList<BuyedIten> buyedItens = new ArrayList<>();
    private Purchase purchase;
    private Payment payment;
    private Client client;

    public UI() {}

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

    public void run() throws PurchaseException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nBem vindo ao supermarket!");
        System.out.println("\nDados do cliente.");

        this.client = clientController.run();

        System.out.println("\nDados do(s) produto(s).");
        System.out.print("Quantos produtos foram comprados? ");
        int qnt = sc.nextInt();

        for(int i = 0; i < qnt; i++) {
            System.out.print("Produto (id e quantidade): ");
            long id = sc.nextLong();
            int quantity = sc.nextInt();
            this.buyedItens.add(
                new BuyedIten(this.stockController.search(id), quantity)
            );
        }

        System.out.println("\nDados do pagamento.");
        System.out.print("Digite o método de pagamento pix (p), crédito (c) ou dinheiro (d): ");
        String paymentMethod = sc.next();

        switch(paymentMethod) {
            case "p" -> {
                System.out.print("Digite sua chave pix: ");
                String key = sc.next();
                this.payment = new Pix(new ArrayList<>(), 0.0, key);
            }
            case "c" -> {
                System.out.print("Digite seus dados (nome, numero e cvv): ");
                this.payment = new Credit(new ArrayList<>(), 0.0, sc.next(), sc.next(), sc.nextInt());
            }
            case "d" -> {
                this.payment = new Money(new ArrayList<>(), 0.0);
            }
        }

        this.purchase = new Purchase(this.client, this.buyedItens, this.payment);
        this.payment.setValue(this.purchase.calcTotal());

        System.out.println("\nValor a pagar: $" + String.format("%.2f", this.payment.getValue()));

        if(this.payment instanceof Pix || this.payment instanceof Money || this.payment instanceof Credit) {
            this.payment.pay();
            System.out.print("\n");
        } else throw new PurchaseException("Purchase: payment not defined as money, credit or pix");

        System.out.println("NF abaixo:");
        System.out.println("\n" + this.purchase);

        sc.close();
    }
}


