package com.app.customermanagement.dto.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


public interface PrescriptionDto {

    Integer getId();
    String getMedicineName();
    String getQuantity();
    String getUnitPrice();
}
