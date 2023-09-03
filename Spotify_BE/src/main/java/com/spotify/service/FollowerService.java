package com.spotify.service;

import com.spotify.entity.Follower;

import java.util.List;
import java.util.Optional;

public interface FollowerService {
    List<Follower> getAllFollower();

    Optional<Follower> getFollowerById(Integer followerId);

    Follower createFollower(Follower follower);

    Follower updateFollower(Follower follower);

    void deleteFollower(Integer followerId);
}
