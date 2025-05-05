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
public class MoneyDetail {

    Integer id;
    String fullName;
    String dateExam;
    Integer status;
    String quantity;
    String medicineName;
    String unitPrice;
    String totalMoney;
}
