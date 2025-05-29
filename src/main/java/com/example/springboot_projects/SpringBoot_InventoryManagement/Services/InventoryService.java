package com.example.springboot_projects.SpringBoot_InventoryManagement.Services;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.ProductNotFoundException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.UnAuthorizedAccessException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.UserNotFoundException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Inventory;

public interface InventoryService {
    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException;
    public void deleteInventory(int userId, int productId) throws  UserNotFoundException, UnAuthorizedAccessException;
}
