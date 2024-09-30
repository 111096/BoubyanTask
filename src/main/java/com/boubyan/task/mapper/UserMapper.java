package com.boubyan.task.mapper;

import com.boubyan.task.model.dao.UserDao;
import com.boubyan.task.model.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDao userDto);

    UserDao toUserDto(User user);

}
