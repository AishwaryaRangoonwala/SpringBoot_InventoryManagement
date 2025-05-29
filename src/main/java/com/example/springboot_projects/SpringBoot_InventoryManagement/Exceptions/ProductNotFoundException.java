package com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
