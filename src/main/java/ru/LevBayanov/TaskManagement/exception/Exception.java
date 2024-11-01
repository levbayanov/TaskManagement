package ru.LevBayanov.TaskManagement.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Exception
{
    private String message;
    private Exception(String message)
    {
        this.message = message;
    }

    public static Exception create(Throwable e)
    {
        return new Exception(e.getMessage());
    }

    public static Exception create(String message)
    {
        return new Exception(message);
    }

}
