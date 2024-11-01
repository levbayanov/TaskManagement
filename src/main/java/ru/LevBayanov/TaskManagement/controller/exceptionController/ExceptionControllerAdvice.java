package ru.LevBayanov.TaskManagement.controller.exceptionController;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ru.LevBayanov.TaskManagement.exception.Exception;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(java.lang.Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ru.LevBayanov.TaskManagement.exception.Exception exception(java.lang.Exception e)
    {
        return ru.LevBayanov.TaskManagement.exception.Exception.create(e);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ru.LevBayanov.TaskManagement.exception.Exception exception(ResourceNotFoundException e)
    {
        return Exception.create(e);
    }

}
