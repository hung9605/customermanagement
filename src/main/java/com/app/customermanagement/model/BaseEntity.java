package com.app.customermanagement.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.app.customermanagement.constants.CommonConstant;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@Data
@FieldDefaults(level =AccessLevel.PRIVATE )
public class BaseEntity {
    @Column(updatable = false)
    String createdBy;
    @Column(updatable = false)
    Date createdAt;
    String updatedBy;
    Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.createdBy = CommonConstant.ADMIN;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
        this.updatedBy = CommonConstant.ADMIN;
    }
}