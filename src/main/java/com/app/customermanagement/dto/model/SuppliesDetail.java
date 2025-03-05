package com.app.customermanagement.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliesDetail {
	
	Integer id;
    String medicineName;
    String unitPrice;
    String quantity;
    String description;
    String link;

}

