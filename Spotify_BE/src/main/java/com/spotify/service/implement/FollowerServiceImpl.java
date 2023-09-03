package com.spotify.service.implement;

import com.spotify.entity.Follower;
import com.spotify.repository.FollowerRepository;
import com.spotify.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowerServiceImpl implements FollowerService {

    private final FollowerRepository followerRepository;

    @Autowired
    public FollowerServiceImpl(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public List<Follower> getAllFollower() {
        return followerRepository.findAll();
    }

    @Override
    public Optional<Follower> getFollowerById(Integer followerId) {
        return followerRepository.findById(followerId);
    }

    @Override
    public Follower createFollower(Follower follower) {
        return followerRepository.save(follower);
    }

    @Override
    public Follower updateFollower(Follower follower) {
        return followerRepository.save(follower);
    }

    @Override
    public void deleteFollower(Integer followerId) {
        followerRepository.deleteById(followerId);
    }
}
