package com.app.customermanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.customermanagement.dto.model.MenuDto;
import com.app.customermanagement.model.Menu;

@Mapper(componentModel = "spring")
public interface MenuMapper {
	
	@Mapping(source = "link", target = "routerLink")
	Menu mapToModel(MenuDto dto);
	@Mapping(source = "routerLink", target = "link")
	MenuDto mapToDto(Menu menu);
	List<Menu> mapToModels(List<MenuDto> dtos);
	List<MenuDto> mapToDtos(List<Menu> menus);

}
