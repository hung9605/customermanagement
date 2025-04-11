package com.app.customermanagement.dto.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {
    Integer id;
    String firstName;
    String midName;
    String lastName;
    String phoneNumber;
    String address;
    Integer status;
    Date dateOfBirth;
    Date createdAt;
    String createdBy;
    Date updatedAt;
    String updatedBy;
    String gender;
    String other;
}
