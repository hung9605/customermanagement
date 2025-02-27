package com.app.customermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
    Boolean status;
    String link;
    String folderName;
    
    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    String description;
//
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "medical_supplies_id",referencedColumnName = "id")
//	List<Prescription> prescriptions;
}
