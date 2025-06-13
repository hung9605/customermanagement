package com.app.customermanagement.dto.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryDTO {
    Long id;
    String medicineName;
    String unitPrice;
    Integer quantity;
    String location;
    String status;
    String supplier;
    Date createdAt;
    String createdBy;
    Date updatedAt;
    String updatedBy;
    
}
