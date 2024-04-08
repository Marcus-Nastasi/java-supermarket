package org.supermarket.Entities.BuyItens;

import org.supermarket.Entities.Products.Product;

public class BuyedItens {

    private Product product;
    private int quantity;

    public BuyedItens(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double calcSubTotal() {
        return this.product.getUnityPrice() * this.quantity + this.calcTaxes();
    }

    private Double calcTaxes() {
        return this.quantity * this.product.getTax();
    }
}


