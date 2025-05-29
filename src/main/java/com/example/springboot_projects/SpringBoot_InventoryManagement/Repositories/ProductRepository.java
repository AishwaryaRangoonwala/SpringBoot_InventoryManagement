package com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
