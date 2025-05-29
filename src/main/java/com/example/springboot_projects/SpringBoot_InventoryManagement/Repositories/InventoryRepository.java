package com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    @Repository
    public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

        Optional<Inventory> findByProductId(int productId);

        void deleteByProductId(int productId);

    }
