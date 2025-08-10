package com.example.unauthorizeddeliveries.dto;

import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class PostingDto {
    private BigInteger matDoc;
    private Integer item;
    private LocalDate docDate;
    private LocalDate pstngDate;
    private String materialDescription;
    private Integer quantity;
    private String bUn;
    private Double amountLc;
    private String crcy;
    private String userName;
    private Boolean authorizedDelivery;
}