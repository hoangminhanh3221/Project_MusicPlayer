package com.spotify.controller;

import com.spotify.dto.FollowerDTO;
import com.spotify.entity.Follower;
import com.spotify.service.FollowerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/follower")
@RequiredArgsConstructor
public class FollowerAPI {

    private final FollowerService followerService;
    private final MessageSource messageSource;

    @GetMapping("/getAll")
    public ResponseEntity<List<Follower>> getAllFollower() {
        return ResponseEntity.ok(followerService.getAllFollower());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createFollower(@RequestBody @Valid FollowerDTO followerDTO) {
        if (followerDTO != null) {
            followerService.createOrUpdate(followerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateFollower(@RequestBody @Valid FollowerDTO followerDTO) {
        Optional<Follower> currentFollower = followerService.getFollowerById(followerDTO.getFollowerId());
        if (currentFollower.isPresent()) {
            followerService.createOrUpdate(followerDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Follower"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFollower(@PathVariable("id") Integer id) {
        Optional<Follower> currentFollower = followerService.getFollowerById(id);
        if (currentFollower.isPresent()) {
            followerService.deleteFollower(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Follower"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
