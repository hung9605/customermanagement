package com.app.customermanagement.model;

import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "medical_supply_id")
    MedicalSupplies medicalSupplies;
    String quantity;
}
