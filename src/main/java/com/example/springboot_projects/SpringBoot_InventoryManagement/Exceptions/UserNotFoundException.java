package com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
