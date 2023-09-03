package com.spotify.service.implement;

import com.spotify.entity.History;
import com.spotify.repository.HistoryRepository;
import com.spotify.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<History> getHistoryById(Integer historyId) {
        return historyRepository.findById(historyId);
    }

    @Override
    public History createHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public History updateHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public void deleteHistory(Integer historyId) {
        historyRepository.deleteById(historyId);
    }
}
