package com.app.customermanagement.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuppliesListDto {
	Integer id;
    String medicineName;
    String unitPrice;
    String quantity;
    Boolean status;
    String link;
    String folderName;
    Boolean isDelete;
}
