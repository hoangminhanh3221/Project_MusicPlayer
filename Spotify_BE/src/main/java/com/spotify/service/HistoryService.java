package com.spotify.service;

import com.spotify.entity.History;

import java.util.List;
import java.util.Optional;

public interface HistoryService {
    List<History> getAllHistory();

    Optional<History> getHistoryById(Integer historyId);

    History createHistory(History history);

    History updateHistory(History history);

    void deleteHistory(Integer historyId);
}
