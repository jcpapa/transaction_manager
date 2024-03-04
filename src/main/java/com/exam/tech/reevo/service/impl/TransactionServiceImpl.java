package com.exam.tech.reevo.service.impl;

import com.exam.tech.reevo.model.TransactionRequest;
import com.exam.tech.reevo.repository.TransactionRequestRepository;
import com.exam.tech.reevo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRequestRepository transactionRequestRepository;

    private TransactionRequest transactionRequest;

    @Override
    public String startTransaction(TransactionRequest t) {
        try {
            transactionRequest = transactionRequestRepository.save(t);
        } catch (Exception e) {
            return null;
        }
        return String.valueOf(transactionRequest.getId());
    }

    @Override
    public String commitTransaction(String t) {
        return null;
    }

    @Override
    public String rollbackTransaction(String t) {
        return null;
    }
}
