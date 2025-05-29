package com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions;

public class UnAuthorizedAccessException extends Exception {

    public UnAuthorizedAccessException(String message) {
        super(message);
    }
}
