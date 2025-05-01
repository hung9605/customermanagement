package com.app.customermanagement.dto.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamDetail extends BaseDto{

    Integer id;
    String fullName;
    String dateRegister;
    String timeRegister;
    String timeActual;
    Integer status;
    String temperature;
    String healthCondition;
    String symptom;
    String typeMedicine;
    String totalMoney;

    public ExamDetail(Integer id, String fullName, String dateRegister, String timeRegister,
                      String timeActual, Integer status, String temperature, String healthCondition,
                      String symptom, String typeMedicine, String totalMoney,
                      Date createdAt, String createdBy, Date updatedAt, String updatedBy) {
        this.id = id;
        this.fullName = fullName;
        this.dateRegister = dateRegister;
        this.timeRegister = timeRegister;
        this.timeActual = timeActual;
        this.status = status;
        this.temperature = temperature;
        this.healthCondition = healthCondition;
        this.symptom = symptom;
        this.typeMedicine = typeMedicine;
        this.totalMoney = totalMoney;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

}
