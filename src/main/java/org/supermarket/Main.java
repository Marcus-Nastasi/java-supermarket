package org.supermarket;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.supermarket.Controllers.Stock.StockController;
import org.supermarket.Entities.BuyItens.BuyedIten;
import org.supermarket.Entities.Clients.Client;
import org.supermarket.Entities.Payment.Credit;
import org.supermarket.Entities.Payment.Payment;
import org.supermarket.Entities.Products.Product;
import org.supermarket.Entities.Products.Tax;
import org.supermarket.Entities.Purchases.Purchase;
import org.supermarket.Entities.Stock.Stock;
import org.supermarket.Exceptions.PurchaseException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        StockController stockController = new StockController(stock);

        Product product = new Product(1234, 12.50, "Apple", new Tax(0.01));
        Product product1 = new Product(2235, 1.99, "Juice", new Tax(0.01));
        BuyedIten buyedIten = new BuyedIten(product, 2);
        BuyedIten buyedIten1 = new BuyedIten(product1, 10);
        ArrayList<BuyedIten> buyedItenArrayList = new ArrayList<>();
        buyedItenArrayList.add(buyedIten);
        buyedItenArrayList.add(buyedIten1);

        Client client = new Client(
            "437.435.088-85", "Marcus Rolemberg", "vinnie.nsts@gmail.com", "1234"
        );

        Payment payment = new Credit(
            new ArrayList<String>(), 20.0, "Marcus", "2234343", 122
        );

        try {
            Purchase purchase = new Purchase(client, buyedItenArrayList, payment);
            System.out.println(purchase);
        } catch(PurchaseException pe) {
            System.err.println("Error: "+pe.getMessage());
        }
    }
}

//String password = "1234";
//String bcryptHashString = BCrypt.withDefaults().hashToString(10, password.toCharArray());

//System.out.println(bcryptHashString);

//BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
//System.out.println(result.verified);

