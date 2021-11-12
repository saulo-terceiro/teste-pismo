package com.example.demo.service;


import com.example.demo.entity.Transaction;
import com.example.demo.exceptions.TransactionValidadorException;
import com.example.demo.requestbody.TransactionRequestBody;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    Transaction post(TransactionRequestBody transactionRequestBody) throws TransactionValidadorException;

    public float getSaldoDisponivel(Long idAccount);
}
