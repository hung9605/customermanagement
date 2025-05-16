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
public class MoneyDto {

     Integer id;
     String fullName;
     String dateExam;
     String totalMoney;
     Integer status;
     Integer idExam;

}
