package com.example.unauthorizeddeliveries.service;

import com.example.unauthorizeddeliveries.model.Login;
import com.example.unauthorizeddeliveries.model.Posting;
import com.example.unauthorizeddeliveries.repository.LoginRepository;
import com.example.unauthorizeddeliveries.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataLoadingService {

    private final CSVService csvService;
    private final LoginRepository loginRepository;
    private final PostingRepository postingRepository;

    @Value("${app.files.logins}")
    private String loginsFilePath;
    
    @Value("${app.files.postings}")
    private String postingsFilePath;

    public DataLoadingService(CSVService csvService, LoginRepository loginRepository, PostingRepository postingRepository) {
        this.csvService = csvService;
        this.loginRepository = loginRepository;
        this.postingRepository = postingRepository;
    }

    @PostConstruct
    public void loadData() throws IOException {
        loadLogins();
        loadPostings();
    }

    private void loadLogins() throws IOException {
        List<Login> logins = csvService.readLoginsFromCSV(loginsFilePath);
        loginRepository.saveAll(logins);
    }

    private void loadPostings() throws IOException {
        List<Posting> postings = csvService.readPostingsFromCSV(postingsFilePath);
        
        List<Posting> enrichedPostings = postings.stream()
                .map(posting -> {
                    boolean isAuthorized = loginRepository.existsByAppAccountNameAndIsActive(
                            posting.getUserName(), true);
                    posting.setAuthorizedDelivery(isAuthorized);
                    return posting;
                })
                .collect(Collectors.toList());
        
        postingRepository.saveAll(enrichedPostings);
    }
}