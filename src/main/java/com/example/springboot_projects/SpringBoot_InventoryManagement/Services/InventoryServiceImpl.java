package com.example.springboot_projects.SpringBoot_InventoryManagement.Services;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.ProductNotFoundException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.UnAuthorizedAccessException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.UserNotFoundException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Inventory;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.InventoryRepository;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.ProductRepository;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException {
        return null;
    }

    @Override
    public void deleteInventory(int userId, int productId) throws UserNotFoundException, UnAuthorizedAccessException {

    }
}
