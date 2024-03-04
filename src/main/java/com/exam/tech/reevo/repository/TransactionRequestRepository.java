package com.exam.tech.reevo.repository;

import com.exam.tech.reevo.model.TransactionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRequestRepository extends JpaRepository<TransactionRequest, Integer> {
}
