package com.app.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.customermanagement.model.Menu;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

    List<Menu> findAllByOrderByOrderNumber();


}
