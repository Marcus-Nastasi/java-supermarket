package org.supermarket.Entities.Stock;

import org.supermarket.Entities.Products.Product;

import java.util.ArrayList;

public class Stock {

    private ArrayList<Product> products = new ArrayList<>();

    public Stock() {}
    public Stock(ArrayList<Product> product) {
        this.products = product;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getProductsString() {
        StringBuilder sb = new StringBuilder();
        for(Product p: products) sb.append(p).append("\n");
        return sb.toString();
    }

    public void addItens(Product product) {
        products.add(product);
    }
}

