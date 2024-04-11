package org.supermarket.Controllers.Stock;

import org.supermarket.Entities.Products.Product;
import org.supermarket.Entities.Products.Tax;
import org.supermarket.Entities.Stock.Stock;

public class StockController {

    private Stock stock;

    public StockController(Stock stock) {
        this.stock = stock;
        initialSetup();
    }

    public String getStock() {
        return stock.toString();
    }

    public void addItem(Product product) {
        this.stock.addItens(product);
    }

    public Product search(long id) {
        for(Product i: stock.getProducts()) if(i.getId() == id) return i;
        return null;
    }

    public void updateProduct(long id, Product product) {
        for(Product i: stock.getProducts()) if(i.getId() == id) i = product;
    }

    public void initialSetup() {
        this.addItem(new Product(1005, 12.50, "Milk", new Tax(12.50*0.01)));
        this.addItem(new Product(1002, 14.50, "Cheese", new Tax(14.50*0.01)));
        this.addItem(new Product(1008, 0.99, "Banana", new Tax(0.99*0.01)));
        this.addItem(new Product(1010, 3.50, "Orange juice", new Tax(3.50*0.01)));
        this.addItem(new Product(1007, 45.50, "Pesto", new Tax(45.50*0.01)));
        this.addItem(new Product(1004, 4.99, "Potatoe", new Tax(4.99*0.01)));
        this.addItem(new Product(1006, 8.10, "Peanut butter", new Tax(8.10*0.01)));
        this.addItem(new Product(1009, 24.00, "Pizza", new Tax(24.00*0.01)));
        this.addItem(new Product(1003, 1.10, "Tomatoe", new Tax(24.00*0.01)));
        this.addItem(new Product(1001, 0.15, "Garlic", new Tax(24.00*0.01)));
    }
}

