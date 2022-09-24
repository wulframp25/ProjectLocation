package com.example.project.service;

import com.example.project.repository.UserRepository;
import com.example.project.entity.User;
import com.example.project.exception.BusinessException;
import com.example.project.util.Messages;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional

public class UserService {
    private final UserRepository userRepository;
    private final Messages messages;

    public UserService(UserRepository userRepository, Messages messages) {
        this.userRepository = userRepository;
        this.messages = messages;
    }

    public User saveUser(User user) {
        Optional<User> userConsult = userRepository.findByEmail(user.getEmail());
        if(userConsult.isPresent()){
            throw new BusinessException(messages.get("user.email.duplicated"));
        }
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        if (Objects.isNull(user.getId())) {
            throw new BusinessException(messages.get("user.id.void"));
        }
        return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public User findUserByEmail(String email, String password) {
        User userConsult = userRepository.findByEmail(email).orElseThrow(
                () -> new BusinessException(messages.get("user.email.not_found")));
        if (!userConsult.getPassword().equals(password)) {
            throw new BusinessException(messages.get("user.password.not_validate"));
        }
        return userConsult;
    }
}
