package com.javarush.zubakha.project.service;

import com.javarush.zubakha.project.entity.User;
import com.javarush.zubakha.project.repository.UserRepository;
import com.javarush.zubakha.project.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public class UserService {
    private final Repository<User> userRepository;

    public UserService(Repository<User> userRepository){
        this.userRepository = userRepository;

    }

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> get(long id) {
        return userRepository.get(id);
    }
}