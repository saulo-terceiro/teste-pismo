package main.com.example.demo.service;

import main.com.example.demo.entity.Account;
import main.com.example.demo.exceptions.AccountValidadorException;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {


    public Account post(Account account) throws AccountValidadorException;

    Account get(Long accountId) throws AccountValidadorException;

    Account getAccount(Long accountId);
}
