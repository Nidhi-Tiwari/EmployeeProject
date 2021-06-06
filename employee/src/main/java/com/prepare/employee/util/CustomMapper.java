package com.prepare.employee.util;

import com.prepare.employee.ControllersPackage.Request.UpdateRequest;
import com.prepare.employee.DataBaseConnection.EmployeeEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface CustomMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromEmployeeTable(UpdateRequest updateRequest, @MappingTarget EmployeeEntity emp);
}
