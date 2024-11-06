package com.app.customermanagement.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.dto.model.MenuDto;
import com.app.customermanagement.mapper.MenuMapper;
import com.app.customermanagement.mapper.MenuMapperImpl;
import com.app.customermanagement.model.Menu;
import com.app.customermanagement.repository.MenuRepository;
import com.app.customermanagement.service.MenuService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService{
	
	private final MenuRepository menuRepository;
	@Override
	public List<MenuDto> getAll() {
		MenuMapper mapper = new MenuMapperImpl();
		return mapper.mapToDtos(menuRepository.findAll());
	}

	@Override
	public Menu addMenu(MenuDto menu) {
		// TODO Auto-generated method stub
		MenuMapper mapper = new MenuMapperImpl();
		return menuRepository.save(mapper.mapToModel(menu));
	}

}
