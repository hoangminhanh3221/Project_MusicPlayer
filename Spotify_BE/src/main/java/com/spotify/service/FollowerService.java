package com.spotify.service;

import com.spotify.dto.FollowerDTO;
import com.spotify.entity.Follower;

import java.util.List;
import java.util.Optional;

public interface FollowerService {
    List<Follower> getAllFollower();

    Optional<Follower> getFollowerById(Integer followerId);

    Follower createOrUpdate(FollowerDTO followerDTO);

    void deleteFollower(Integer followerId);
}
