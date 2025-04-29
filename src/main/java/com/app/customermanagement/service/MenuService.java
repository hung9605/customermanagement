package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.dto.model.MenuDto;
import com.app.customermanagement.model.Menu;

public interface MenuService {
	
	List<MenuDto> getAll();
	Menu addMenu(MenuDto menu);
//	List<MenuDto> getAllAdMenu();
	
	Integer setVisible(MenuDto dto);

}
