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
public class ExamDetail extends BaseDto{

    Integer id;
    String fullName;
    String dateRegister;
    String timeRegister;
    String timeActual;
    String status;
    String temperature;
    String healthCondition;
    String symptom;
    String typeMedicine;
    String totalMoney;

}
