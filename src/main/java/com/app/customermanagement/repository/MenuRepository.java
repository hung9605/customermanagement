package com.app.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customermanagement.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
