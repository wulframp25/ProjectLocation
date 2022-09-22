package com.example.proyecto.Facade;

import com.example.proyecto.Service.UserService;
import com.example.proyecto.entity.User;
import com.example.proyecto.mapper.UserMapper;
import com.example.proyecto.modelo.UserDTO;

public class UserFacade {

    private final UserService  userService;
    private final UserMapper userMapper;


    public UserFacade(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public UserDTO saverUser(UserDTO user) {
        return userMapper.toDto(userService.saveUser(userMapper.toEntity(user)));
    }

    public UserDTO updateUser(UserDTO user) {
        return userMapper.toDto(userService.updateUser(userMapper.toEntity(user)));
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }


    public UserDTO findUserByEmail(String email, String password) {
        User user = userService.findUserByEmail(email, password);
        UserDTO userDTO = userMapper.toDto(user);
        return userDTO;
    }
}
