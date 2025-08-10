package com.example.unauthorizeddeliveries.repository;

import com.example.unauthorizeddeliveries.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
    @Query("SELECT p FROM Posting p WHERE p.pstngDate BETWEEN :startDate AND :endDate " +
           "AND (:authorized IS NULL OR p.authorizedDelivery = :authorized)")
    List<Posting> findByPeriodAndAuthorized(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("authorized") Boolean authorized);
}