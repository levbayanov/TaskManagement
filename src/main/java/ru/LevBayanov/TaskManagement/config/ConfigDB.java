package ru.LevBayanov.TaskManagement.config;

import ru.LevBayanov.TaskManagement.entity.Task;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.LevBayanov.TaskManagement.entity.User;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class ConfigDB {

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Task> taskContainer() {
        return new ArrayList<>();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<User> userContainer() {
        return new ArrayList<>();
    }
}
