package com.example.unauthorizeddeliveries.model;

import com.example.unauthorizeddeliveries.converter.BooleanConverter;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "logins")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @CsvBindByPosition(position = 0)
    private String application;

    @Column(nullable = false)
    @CsvBindByPosition(position = 1)
    private String appAccountName;

    @Column(nullable = false)
    @CsvBindByPosition(position = 2)
    @CsvCustomBindByName(converter = BooleanConverter.class)
    private Boolean isActive;

    @Column(nullable = false)
    @CsvBindByPosition(position = 3)
    private String jobTitle;

    @Column(nullable = false)
    @CsvBindByPosition(position = 4)
    private String department;
}