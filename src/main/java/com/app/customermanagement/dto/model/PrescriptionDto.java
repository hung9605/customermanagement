package com.app.customermanagement.dto.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
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
    
}