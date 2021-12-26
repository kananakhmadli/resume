package com.company.service;

import com.company.entity.User;
import com.company.repository.UserRepositoryCustom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepositoryCustom userRepository;

    public UserService(UserRepositoryCustom userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(String name, String surname, Integer nationalityId) {
        return userRepository.getAll(name, surname, nationalityId);
    }

    public boolean updateUser(User u) {
        return userRepository.updateUser(u);
    }

    public boolean removeUser(int id) {
        return userRepository.removeUser(id);
    }

    public User getById(int userId) {
        return userRepository.getById(userId);
    }

    public boolean addUser(User u) {
        return userRepository.addUser(u);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}