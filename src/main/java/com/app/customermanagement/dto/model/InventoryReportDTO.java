package com.app.customermanagement.dto.model;


import java.util.Date;

public interface InventoryReportDTO {
    Long getId();
    String getMedicineName();
    String getUnitPrice();
    Integer getQuantity();
    String getLocation();
    String getStatus();
    String getSupplier();
    Date receivedDate();
    Date getCreatedAt();
    String getCreatedBy();
    Date getUpdatedAt();
    String getUpdatedBy();
    Integer getTotalQuantity();
    String getRecordType();
    String getDescription();
}
