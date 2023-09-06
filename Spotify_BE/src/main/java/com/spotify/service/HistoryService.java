package com.spotify.service;

import com.spotify.dto.HistoryDTO;
import com.spotify.entity.History;

import java.util.List;
import java.util.Optional;

public interface HistoryService {
    List<History> getAllHistory();
    Optional<History> getHistoryById(Integer historyId);
    History createOrUpdate(HistoryDTO historyDTO);
    void deleteHistory(Integer historyId);
}
