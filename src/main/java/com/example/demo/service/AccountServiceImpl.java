package com.example.demo.service;


import com.example.demo.entity.Account;
import com.example.demo.exceptions.AccountValidadorException;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account post(Account account) throws AccountValidadorException {
        validarAccount(account);
        return accountRepository.save(account);
    }

    @Override
    public Account get(Long accountId) throws AccountValidadorException {
        try{
            return accountRepository.findById(accountId).get();
        }catch (NoSuchElementException n){
            throw new AccountValidadorException("Não existe conta pra id informado");
        }
    }

    @Override
    public Account getAccount(Long accountId){
        return  accountRepository.findById(accountId).get();
    }

    public void validarAccount(Account account) throws AccountValidadorException {
        //validacao
        if(account.getCredit_limit()<0){
            throw new AccountValidadorException("Valor de limite de credito negativo");
        }

    }
}
