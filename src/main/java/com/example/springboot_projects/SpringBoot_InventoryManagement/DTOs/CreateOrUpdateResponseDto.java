package com.example.springboot_projects.SpringBoot_InventoryManagement.DTOs;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Enums.ResponseStatus;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Inventory;

public class CreateOrUpdateResponseDto {
    private Inventory inventory;
    private ResponseStatus responseStatus;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
