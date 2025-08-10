package com.example.unauthorizeddeliveries.service;

import com.example.unauthorizeddeliveries.model.Posting;
import com.example.unauthorizeddeliveries.repository.PostingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostingService {

    private final PostingRepository postingRepository;

    public PostingService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    public List<Posting> getPostingsByPeriod(LocalDate startDate, LocalDate endDate, Boolean authorized) {
        return postingRepository.findByPeriodAndAuthorized(startDate, endDate, authorized);
    }
}