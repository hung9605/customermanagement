package com.app.customermanagement.dto.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuDto {
	
	Integer id;
	String label;
	String link;
	String icon;
	String orderNumber;
	String createdAt;
	String createdBy;
	String updatedAt;
	String updatedBy;
	Integer idParent;
	Boolean visible;

}
