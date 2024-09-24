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
@Table(name = "medical_examination")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedicalExamination extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String dayOfExaminatiom;
    String sympton;
    String treatment;
    String typeOfMedicine;
}
