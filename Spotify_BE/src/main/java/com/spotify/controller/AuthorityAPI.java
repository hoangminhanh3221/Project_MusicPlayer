package com.spotify.controller;

import com.spotify.dto.AuthorityDTO;
import com.spotify.entity.Authority;
import com.spotify.service.AuthorityService;
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
@RequestMapping("/api/authority")
@RequiredArgsConstructor
public class AuthorityAPI {

    private final AuthorityService authorityService;
    private final MessageSource messageSource;

    @GetMapping("/getAll")
    public ResponseEntity<List<Authority>> getAllAuthority() {
        return ResponseEntity.ok(authorityService.getAllAuthority());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createAuthority(@RequestBody @Valid AuthorityDTO authorityDTO) {
        if (authorityDTO != null) {
            authorityService.createOrUpdate(authorityDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateAuthority(@RequestBody @Valid AuthorityDTO authorityDTO) {
        Optional<Authority> currentAuthority = authorityService.getAuthorityById(authorityDTO.getAuthorityId());
        if (currentAuthority.isPresent()) {
            authorityService.createOrUpdate(authorityDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Authority"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAuthority(@PathVariable("id") Integer id) {
        Optional<Authority> currentAuthority = authorityService.getAuthorityById(id);
        if (currentAuthority.isPresent()) {
            authorityService.deleteAuthority(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Authority"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
