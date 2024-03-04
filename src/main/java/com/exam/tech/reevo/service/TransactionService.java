package com.exam.tech.reevo.service;

import com.exam.tech.reevo.model.TransactionRequest;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    public String startTransaction(TransactionRequest t);
    public String commitTransaction(String t);
    public String rollbackTransaction(String t);
}
