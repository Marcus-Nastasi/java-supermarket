package org.supermarket.Entities.Stock;

import org.supermarket.Entities.Products.Product;

import java.util.ArrayList;

public class Stock {

    private ArrayList<Product> products = new ArrayList<>();
    private int quantity;

    public Stock(ArrayList<Product> product, int quantity) {
        this.products = product;
        this.quantity = quantity;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addItens(Product product) {
        products.add(product);
    }
}

