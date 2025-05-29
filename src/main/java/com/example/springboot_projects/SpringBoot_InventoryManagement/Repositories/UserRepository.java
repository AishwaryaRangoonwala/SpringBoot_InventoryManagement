package com.example.springboot_projects.SpringBoot_InventoryManagement.Repositories;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
