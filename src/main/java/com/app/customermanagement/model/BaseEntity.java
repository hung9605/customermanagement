package com.app.customermanagement.model;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@Data
@FieldDefaults(level =AccessLevel.PRIVATE )
public class BaseEntity {
    String createdBy;
    Date createdAt;
    String updatedBy;
    Date updatedAt;
}