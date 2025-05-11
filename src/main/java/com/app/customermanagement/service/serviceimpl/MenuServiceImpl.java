package com.app.customermanagement.service.serviceimpl;

import com.app.customermanagement.dto.model.MenuDto;
import com.app.customermanagement.mapper.MenuMapper;
import com.app.customermanagement.model.Menu;
import com.app.customermanagement.repository.MenuRepository;
import com.app.customermanagement.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService{
	
	private final MenuRepository menuRepository;
	private final MenuMapper mapper;
	
	@Cacheable(value = "menuCache")
	@Override
	public List<MenuDto> getAll() {
		return mapper.mapToDtos(menuRepository.findAllByOrderByOrderNumber());
	}

	@Override
	public Menu addMenu(MenuDto menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(mapper.mapToModel(menu));
	}

	@Override
	public Integer setVisible(MenuDto dto) {
		// TODO Auto-generated method stub
		return menuRepository.updateVisible(dto.getVisible(), dto.getId());
	}

	/**
	 * @param dto
	 */
	@Override
	public void deleteMenu(MenuDto dto) throws Exception {
		menuRepository.deleteById(dto.getId());
	}

	@CacheEvict(value = "menuCache", allEntries = true)
	@Override
	public void refreshCache() {
		// TODO Auto-generated method stub
		
	}

}
