package com.example.springboot_projects.SpringBoot_InventoryManagement.Controllers;

import com.example.springboot_projects.SpringBoot_InventoryManagement.DTOs.CreateOrUpdateRequestDto;
import com.example.springboot_projects.SpringBoot_InventoryManagement.DTOs.CreateOrUpdateResponseDto;
import com.example.springboot_projects.SpringBoot_InventoryManagement.DTOs.DeleteInventoryRequestDto;
import com.example.springboot_projects.SpringBoot_InventoryManagement.DTOs.DeleteInventoryResponseDto;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Enums.ResponseStatus;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Models.Inventory;
import com.example.springboot_projects.SpringBoot_InventoryManagement.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public CreateOrUpdateResponseDto createOrUpdateInventory(CreateOrUpdateRequestDto requestDto){
        CreateOrUpdateResponseDto responseDto = new CreateOrUpdateResponseDto();
        try {
            Inventory inventory = inventoryService.createOrUpdateInventory(
                    requestDto.getUserId(),
                    requestDto.getProductId(),
                    requestDto.getQuantity());
            responseDto.setInventory(inventory);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        }
        catch(Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }

    public DeleteInventoryResponseDto deleteInventory(DeleteInventoryRequestDto requestDto){
        DeleteInventoryResponseDto responseDto = new DeleteInventoryResponseDto();
        try {
            inventoryService.deleteInventory(
                    requestDto.getUserId(),
                    requestDto.getProductId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        }
        catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }


}
