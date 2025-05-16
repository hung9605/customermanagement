package com.app.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.model.Menu;

import java.util.List;


public interface MenuRepository extends JpaRepository<Menu, Integer>{

    List<Menu> findAllByOrderByOrderNumber();
    

    @Modifying
    @Transactional
    @Query("UPDATE Menu m SET m.visible = :visible WHERE m.id = :id")
    Integer updateVisible(@Param("visible") Boolean visible, @Param("id") Integer id);


}
