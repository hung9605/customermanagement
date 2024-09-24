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
@Table(name = "schedule_medical")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String fullName;
    String timeRegister;
    String dateRegister;
    Integer status;

}
