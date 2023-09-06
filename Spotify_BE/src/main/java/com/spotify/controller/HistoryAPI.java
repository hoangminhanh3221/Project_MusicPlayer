package com.spotify.controller;

import com.spotify.dto.HistoryDTO;
import com.spotify.entity.History;
import com.spotify.service.HistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/history")
public class HistoryAPI {

    private final HistoryService historyService;
    private final MessageSource messageSource;

    @Autowired
    public HistoryAPI(HistoryService historyService, MessageSource messageSource) {
        this.historyService = historyService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<History>> getAllHistory() {
        return ResponseEntity.ok(historyService.getAllHistory());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createHistory(@RequestBody @Valid HistoryDTO historyDTO) {
        if (historyDTO != null) {
            historyService.createOrUpdate(historyDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateHistory(@RequestBody @Valid HistoryDTO historyDTO) {
        Optional<History> currentHistory = historyService.getHistoryById(historyDTO.getHistoryId());
        if (currentHistory.isPresent()) {
            historyService.createOrUpdate(historyDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"History"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteHistory(@PathVariable("id") Integer id) {
        Optional<History> currentHistory = historyService.getHistoryById(id);
        if (currentHistory.isPresent()) {
            historyService.deleteHistory(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"History"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
