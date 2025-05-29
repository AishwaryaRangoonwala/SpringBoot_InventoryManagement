package com.example.springboot_projects.SpringBoot_InventoryManagement;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Enums.UserType;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Inventory;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Product;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.User;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.InventoryRepository;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.ProductRepository;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootInventoryManagementApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private InventoryRepository inventoryRepository;

	public void loadData() {
		// User-1
		User user1 = new User();
		user1.setName("Aishwarya");
		user1.setEmail("aish.rangoon@gmail.com");
		user1.setUserType(UserType.ADMIN);
		userRepository.save(user1);
		// User-2
		User user2 = new User();
		user2.setName("Devis");
		user2.setEmail("devis.rangoon@gmail.com");
		user2.setUserType(UserType.CUSTOMER);
		userRepository.save(user2);
		// Product-1
		Product product1 = new Product();
		product1.setName("Product 1");
		product1.setDescription("Description of Product-1");
		product1.setPrice(25.30);
		Product savedP1 = productRepository.save(product1);
		// Product-2
		Product product2 = new Product();
		product2.setName("Product 2");
		product2.setDescription("Description of Product-2");
		product2.setPrice(30.30);
		Product savedP2 = productRepository.save(product2);
		// Inventory-1
		Inventory inv1 = new Inventory();
		inv1.setProduct(savedP1);
		inv1.setQuantity(10);
		inventoryRepository.save(inv1);
		// Inventory -2
		Inventory inv2 = new Inventory();
		inv2.setProduct(savedP2);
		inv2.setQuantity(4);
		inventoryRepository.save(inv2);
	}


	public static void main(String[] args)  {
		SpringApplication.run(SpringBootInventoryManagementApplication.class, args);
		System.out.println("*************** INVENTORY MANAGEMENT ***************");

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*************** INVENTORY MANAGEMENT RUN  ***************");
		// loadData();
	}
}
