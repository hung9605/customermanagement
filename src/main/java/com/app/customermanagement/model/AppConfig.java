package com.app.customermanagement.model;

import org.springframework.context.annotation.Primary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "app_config")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfig extends BaseEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer id;
		String configKey;
		String configValue;
	
}
