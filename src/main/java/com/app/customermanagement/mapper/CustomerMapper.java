package com.app.customermanagement.mapper;

import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto maptoDto(Customer customer);
    Customer maptoModel(CustomerDto customerDto);

}
