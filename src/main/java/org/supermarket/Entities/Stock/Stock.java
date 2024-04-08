package org.supermarket.Entities.Stock;

import org.supermarket.Entities.Products.Product;

import java.util.ArrayList;

public class Stock {

    private ArrayList<Product> products = new ArrayList<>();

    public Stock(ArrayList<Product> product) {
        this.products = product;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addItens(Product product) {
        products.add(product);
    }

    public void deleteItens(long id) {
        this.products.remove(id);
    }
}

