package com.boubyan.task.mapper;

import com.boubyan.task.model.dao.RoleDao;
import com.boubyan.task.model.entity.Role;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-30T14:31:48+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toRole(RoleDao userDto) {
        if ( userDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( userDto.getId() );
        role.setName( userDto.getName() );

        return role;
    }

    @Override
    public RoleDao toRoleDto(Role user) {
        if ( user == null ) {
            return null;
        }

        RoleDao roleDao = new RoleDao();

        roleDao.setId( user.getId() );
        roleDao.setName( user.getName() );

        return roleDao;
    }
}
