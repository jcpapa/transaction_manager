package com.exam.tech.reevo.controller;

import com.exam.tech.reevo.model.TransactionRequest;
import com.exam.tech.reevo.service.TransactionService;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/start")
    @Retryable(value = { TransactionException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public ResponseEntity<String> startTransaction(@RequestBody TransactionRequest request) {
        try {
            String transactionId = transactionService.startTransaction(request);
            return ResponseEntity.ok(transactionId);
        } catch (TransactionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping("/commit/{transactionId}")
    @Retryable(value = { TransactionException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public ResponseEntity<String> commitTransaction(@PathVariable String transactionId) {
        try {
            transactionService.commitTransaction(transactionId);
            return ResponseEntity.ok("Transaction committed successfully");
        } catch (TransactionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/rollback/{transactionId}")
    @Retryable(value = { TransactionException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public ResponseEntity<String> rollbackTransaction(@PathVariable String transactionId) {
        try {
            transactionService.rollbackTransaction(transactionId);
            return ResponseEntity.ok("Transaction rolled back successfully");
        } catch (TransactionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
