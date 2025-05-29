package com.example.springboot_projects.SpringBoot_InventoryManagement.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity (name = "inventory")
public class Inventory extends BaseModel {
    // Inventory 1 : 1 Product
    @OneToOne
    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
