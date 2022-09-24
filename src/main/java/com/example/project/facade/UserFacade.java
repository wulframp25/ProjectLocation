package com.example.project.facade;

import com.example.project.service.UserService;
import com.example.project.entity.User;
import com.example.project.mapper.UserMapper;
import com.example.project.model.UserDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
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
