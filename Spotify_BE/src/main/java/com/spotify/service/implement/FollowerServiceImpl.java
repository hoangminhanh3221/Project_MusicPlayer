package com.spotify.service.implement;

import com.spotify.dto.FollowerDTO;
import com.spotify.entity.Follower;
import com.spotify.repository.FollowerRepository;
import com.spotify.service.FollowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FollowerServiceImpl implements FollowerService {

    private final FollowerRepository followerRepository;

    @Override
    public List<Follower> getAllFollower() {
        return followerRepository.findAll();
    }

    @Override
    public Optional<Follower> getFollowerById(Integer followerId) {
        return followerRepository.findById(followerId);
    }

    @Override
    public Follower createOrUpdate(FollowerDTO followerDTO) {
        Follower follower = new Follower();
        BeanUtils.copyProperties(followerDTO, follower);
        return followerRepository.save(follower);
    }

    @Override
    public void deleteFollower(Integer followerId) {
        followerRepository.deleteById(followerId);
    }
}
