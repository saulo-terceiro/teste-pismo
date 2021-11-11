package main.java.com.example.demo.service;

import main.java.com.example.demo.entity.Transaction;
import main.java.com.example.demo.requestbody.TransactionRequestBody;
import main.java.com.example.demo.exceptions.TransactionValidadorException;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    Transaction post(TransactionRequestBody transactionRequestBody) throws TransactionValidadorException;
}
