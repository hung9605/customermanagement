package com.app.customermanagement.dto.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrescriptionDto {

    Integer id;
    String medicineName;
    Integer IdSupplies;
    Integer IdExam;
    String quantity;
    String unitPrice;
	public PrescriptionDto(Integer id, String medicineName, String quantity, String unitPrice) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
    
    
    
}