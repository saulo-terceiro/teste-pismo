package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    List<Transaction> findAllByAccount(Account account);
}
