package com.spotify.service;

import com.spotify.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    Optional<User> getUserById(Integer userId);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Integer userId);
}
