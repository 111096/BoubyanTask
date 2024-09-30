package com.boubyan.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserCourseDuplicateException extends Exception {

    public UserCourseDuplicateException(String message) {
        super(message);
    }

}
