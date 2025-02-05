package com.app.customermanagement.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medical_supplies")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedicalSupplies extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String medicineName;
    String unitPrice;
    String quantity;
}
