package com.example.springboot_projects.SpringBoot_InventoryManagement.Services;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Enums.UserType;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.ProductNotFoundException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.UnAuthorizedAccessException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Exceptions.UserNotFoundException;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Inventory;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Product;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.User;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.InventoryRepository;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.ProductRepository;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        userExceptions(userId);
        // ProductNotFoundException
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) throw new ProductNotFoundException("Product Not Found!");
        // Check whether the productId exists in the inventory or not
        Optional<Inventory> inventoryOptional = inventoryRepository.findByProductId(productId);
        // If it does not exists, we will create an inventory object
        // and save it in the InventoryRepository
        Inventory inventory;
        if (inventoryOptional.isEmpty()) {
            inventory = new Inventory();
            inventory.setProduct(productOptional.get());
            inventory.setQuantity(quantity);
        }
        // If it exists, we will update the count of the product in the inventory repository
        // Return the Inventory object
        else {
            inventory = inventoryOptional.get();
            inventory.setQuantity(quantity + inventory.getQuantity());
        }
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(int userId, int productId) throws  UserNotFoundException, UnAuthorizedAccessException {
        // UserNotFoundException
        // UnAuthorizedException
        userExceptions(userId);
        // Check whether the productId is present in the inventory or not
        // If present, then delete it from the inventory
        Optional<Inventory> inventoryOptional = inventoryRepository.findByProductId(productId);
        if (inventoryOptional.isPresent()) inventoryRepository.deleteByProductId(productId);
    }

    public void userExceptions(int userId) throws UserNotFoundException, UnAuthorizedAccessException {
        // UserNotFoundException
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) throw new UserNotFoundException("User Not Found!");
        // UnauthorizedException
        User user = userOptional.get();
        if (!user.getUserType().equals(UserType.ADMIN)) throw new UnAuthorizedAccessException("User not authorized!");
    }
}
