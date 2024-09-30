package com.boubyan.task.mapper;

import com.boubyan.task.model.dao.RoleDao;
import com.boubyan.task.model.entity.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface RoleMapper {

    Role toRole(RoleDao userDto);

    RoleDao toRoleDto(Role user);

}
