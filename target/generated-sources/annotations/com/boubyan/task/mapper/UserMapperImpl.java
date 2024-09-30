package com.boubyan.task.mapper;

import com.boubyan.task.model.dao.UserDao;
import com.boubyan.task.model.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-30T14:31:48+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDao userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUserName( userDto.getUserName() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public UserDao toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDao userDao = new UserDao();

        userDao.setId( user.getId() );
        userDao.setUserName( user.getUserName() );
        userDao.setEmail( user.getEmail() );
        userDao.setPassword( user.getPassword() );

        return userDao;
    }
}
