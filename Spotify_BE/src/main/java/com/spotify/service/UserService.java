package com.spotify.service;

import com.spotify.dto.UserDTO;
import com.spotify.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();
    Optional<User> getUserById(Integer userId);
    User createOrUpdate(UserDTO userDTO);
    void deleteUser(Integer userId);
}
