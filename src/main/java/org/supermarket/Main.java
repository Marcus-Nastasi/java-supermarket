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
import org.supermarket.Entities.UIs.UI;
import org.supermarket.Exceptions.PurchaseException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.runUI();
    }
}

//String password = "1234";
//String bcryptHashString = BCrypt.withDefaults().hashToString(10, password.toCharArray());

//System.out.println(bcryptHashString);

//BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
//System.out.println(result.verified);

