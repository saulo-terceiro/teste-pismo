package com.example.demo.service;


import com.example.demo.entity.Account;
import com.example.demo.entity.OperationType;
import com.example.demo.entity.Transaction;
import com.example.demo.exceptions.AccountValidadorException;
import com.example.demo.exceptions.TransactionValidadorException;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.requestbody.TransactionRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    AccountService accountService;

    @Autowired
    OperationTypeService operationTypeService;

    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public Transaction post(TransactionRequestBody transactionRequestBody) throws TransactionValidadorException {
        this.validarTransaction(transactionRequestBody);
        Account account = accountService.getAccount(transactionRequestBody.getAccount_id());
        OperationType operationType = operationTypeService.getOperationType(transactionRequestBody.getOperation_type_id());
        Date eventDate = new Date();
        Transaction transaction = new Transaction(account,operationType,transactionRequestBody.getAmount(),eventDate);

        if(operationType.getTipo().equals(OperationType.TIPO_DEBITO)){
            transaction.setAmount(-transactionRequestBody.getAmount());
        }


        return transactionRepository.save(transaction);
    }

    public void validarTransaction(TransactionRequestBody transactionRequestBody) throws TransactionValidadorException {
        try {
            accountService.get(transactionRequestBody.getAccount_id());
        } catch (AccountValidadorException e) {
            throw new TransactionValidadorException("Account não existe para esse ID");
        }

        try{
            operationTypeService.getOperationType(transactionRequestBody.getOperation_type_id());
        }catch (NoSuchElementException n){
            throw new TransactionValidadorException("Não existe esse tipo de operação");
        }

        if(transactionRequestBody.getAmount()<0){
            throw new TransactionValidadorException("Amount negativo é invalido");
        }

    }
}
