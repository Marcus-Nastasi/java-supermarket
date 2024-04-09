package org.supermarket.Entities.Products;

public class Product {

    private long id;
    private Double unityPrice;
    protected String description;
    protected Tax tax;

    public Product(long id, Double unityPrice, String description, Tax tax) {
        this.id = id;
        this.unityPrice = unityPrice;
        this.description = description;
        this.tax = tax;
    }

    public long getId() {
        return id;
    }

    public Double getUnityPrice() {
        return unityPrice;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTax() {
        return tax.getTax();
    }

    @Override
    public String toString() {
        return(
            "Name: " + this.getDescription() +
            "\nPrice: $" + String.format("%.2f%n", this.getUnityPrice()) + "\n"
        );
    }
}

