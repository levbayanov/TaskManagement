package ru.LevBayanov.TaskManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.LevBayanov.TaskManagement.entity.RoleEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;
import ru.LevBayanov.TaskManagement.repository.UserRepository;
import ru.LevBayanov.TaskManagement.service.Impl.UserService;
import ru.LevBayanov.TaskManagement.exception.Exception;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(UserEntity user)
    {
        UserEntity userFromDB = userRepository.findByUserName(user.getUserName());
        if(userFromDB != null)
        {
            Exception.create("user exist");
        }
        user.setRoles(Collections.singleton(RoleEntity.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserEntity foundUser = userRepository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(
                foundUser.getUserName(),
                foundUser.getPassword(),
                mapRole(foundUser.getRoles()));

    }

    private Collection<GrantedAuthority> mapRole(Set<RoleEntity> roles)
    {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toSet());
    }
}
