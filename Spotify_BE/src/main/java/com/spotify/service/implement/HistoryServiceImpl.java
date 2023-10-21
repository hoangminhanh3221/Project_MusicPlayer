package com.spotify.service.implement;

import com.spotify.dto.HistoryDTO;
import com.spotify.entity.History;
import com.spotify.repository.HistoryRepository;
import com.spotify.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<History> getHistoryById(Integer historyId) {
        return historyRepository.findById(historyId);
    }

    @Override
    public History createOrUpdate(HistoryDTO historyDTO) {
        History history = new History();
        BeanUtils.copyProperties(historyDTO, history);
        return historyRepository.save(history);
    }

    @Override
    public void deleteHistory(Integer historyId) {
        historyRepository.deleteById(historyId);
    }
}
