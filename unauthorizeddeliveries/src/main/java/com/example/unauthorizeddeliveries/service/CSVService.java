package com.example.unauthorizeddeliveries.service;

import com.example.unauthorizeddeliveries.model.Login;
import com.example.unauthorizeddeliveries.model.Posting;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CSVService {

    public List<Login> readLoginsFromCSV(String filePath) throws IOException {
        try (Reader reader = new InputStreamReader(
                new ClassPathResource(filePath).getInputStream(), StandardCharsets.UTF_8)) {
            CsvToBean<Login> csvToBean = new CsvToBeanBuilder<Login>(reader)
                    .withType(Login.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .withSeparator(',')
                    .build();
            
            List<Login> logins = csvToBean.parse();
            return logins;
        }
    }

    public List<Posting> readPostingsFromCSV(String filePath) throws IOException {
    try (Reader reader = new InputStreamReader(
            new ClassPathResource(filePath).getInputStream(), StandardCharsets.UTF_8)) {
        
        CsvToBean<Posting> csvToBean = new CsvToBeanBuilder<Posting>(reader)
                .withType(Posting.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withSeparator(';')
                .withSkipLines(1)
                .build();

        List<Posting> allPostings = csvToBean.parse();
        
        // Фильтруем записи с quantity >= 0
        List<Posting> validPostings = allPostings.stream()
                .filter(posting -> {
                    if (posting.getQuantity() < 0) {
                        System.out.println("Skipping record with negative quantity: " 
                                + posting.getMatDoc() + "-" + posting.getItem() 
                                + ", Quantity: " + posting.getQuantity());
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
        
        System.out.println("Filtered " + (allPostings.size() - validPostings.size()) 
                + " records with negative quantity");
        // либо можно all, но отрицательности в данных я не понял
        return validPostings;
    }
}
}   