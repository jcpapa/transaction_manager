package com.exam.tech.reevo.service;

import com.exam.tech.reevo.model.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionCoordinator {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${transaction.manager.url}")
    private String transactionManagerUrl;

    public void initiateTransaction(TransactionRequest request) {
        // Send request to Transaction Manager
        restTemplate.postForObject(transactionManagerUrl + "/transactions/start", request, String.class);
    }

    public void commitTransaction(String transactionId) {
        // Send request to Transaction Manager
        restTemplate.postForObject(transactionManagerUrl + "/transactions/commit/" + transactionId, null, String.class);
    }

    public void rollbackTransaction(String transactionId) {
        // Send request to Transaction Manager
        restTemplate.postForObject(transactionManagerUrl + "/transactions/rollback/" + transactionId, null, String.class);
    }
}
