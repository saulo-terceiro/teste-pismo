package main.com.example.demo.service;

import main.com.example.demo.entity.Transaction;
import main.com.example.demo.requestbody.TransactionRequestBody;
import main.com.example.demo.exceptions.TransactionValidadorException;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    Transaction post(TransactionRequestBody transactionRequestBody) throws TransactionValidadorException;
}
