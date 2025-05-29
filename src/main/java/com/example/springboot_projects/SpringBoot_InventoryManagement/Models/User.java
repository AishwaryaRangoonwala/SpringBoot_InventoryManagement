package com.example.springboot_projects.SpringBoot_InventoryManagement.Models;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity (name = "users")
public class User extends BaseModel {
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
