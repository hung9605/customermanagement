package com.app.customermanagement.dto.model;

import java.util.Date;

public interface AuditDto {
	

    String getCreatedBy();
    Date getCreatedAt();
    String getUpdatedBy();
    Date getUpdatedAt();

}
