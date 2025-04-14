package com.app.customermanagement.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medical_examination")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedicalExamination extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String dayOfExamination;
    String temperature;
    String healthCondition;
    String sympton;
    String treatment;
    String typeOfMedicine;
    String money;
    Integer status;
    String totalMoney;
    String quantity;
    String timeActual;
    
    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_medical_id",referencedColumnName = "id")
    ScheduleMedical medical;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_examination_id",referencedColumnName = "id")
    @JsonIgnore
    List<Prescription> prescription;

}
