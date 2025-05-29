package com.example.springboot_projects.SpringBoot_InventoryManagement.DTOs;

import com.example.springboot_projects.SpringBoot_InventoryManagement.Enums.ResponseStatus;

public class DeleteInventoryResponseDto {
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
