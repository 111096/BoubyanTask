package com.boubyan.task.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDao extends BaseDao {

    private String userName;
    private String email;
    private String password;

}
