package com.app.customermanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prescription")
public class Prescription extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String quantity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_supplies_id")
    MedicalSupplies medicalSupplies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_examination_id")
    MedicalExamination medicalExamination;
}