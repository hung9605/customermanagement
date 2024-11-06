package com.app.customermanagement.model;

import java.util.Date;

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
@Table(name = "menu")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Menu {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	String label;
	String routerLink;
	String icon;
	Integer idParent;
}
