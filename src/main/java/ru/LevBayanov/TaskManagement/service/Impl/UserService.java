package ru.LevBayanov.TaskManagement.service.Impl;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

public interface UserService{

    void addUser(UserEntity user);

}
