package com.app.customermanagement.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyDto {

    private Integer id;
    private String fullName;
    private String dateExam;
    private String totalMoney;
    private Integer status;

}
