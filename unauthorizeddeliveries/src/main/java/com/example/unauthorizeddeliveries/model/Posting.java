package com.example.unauthorizeddeliveries.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

@Data
@Entity
@Table(name = "postings")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @CsvBindByPosition(position = 0)
    private BigInteger matDoc;

    @Column(nullable = false)
    @CsvBindByPosition(position = 1)
    private Integer item;

    @Column(nullable = false)
    @CsvBindByPosition(position = 2)
    @CsvDate("dd.MM.yyyy")
    private LocalDate docDate;

    @Column(nullable = false)
    @CsvBindByPosition(position = 3)
    @CsvDate("dd.MM.yyyy")
    private LocalDate pstngDate;

    @Column(nullable = false)
    @CsvBindByPosition(position = 4)
    private String materialDescription;

    @Column(nullable = false)
    @CsvBindByPosition(position = 5)
    private Integer quantity;

    @Column(nullable = false)
    @CsvBindByPosition(position = 6)
    private String bUn;

    @Column(nullable = false)
    @CsvBindByPosition(position = 7)
    private Double amountLc;

    @Column(nullable = false)
    @CsvBindByPosition(position = 8)
    private String crcy;

    @Column(nullable = false)
    @CsvBindByPosition(position = 9)
    private String userName;
    private Boolean authorizedDelivery; // добавить
}