package main.java.com.example.demo.dtos;

import main.java.com.example.demo.entity.Transaction;

import java.util.Date;

public class TransactionDtoResponse {

    Long transactionId;
    Long accountId;
    Long operationTypeId;
    float amount;
    Date eventDate;

    public TransactionDtoResponse(Transaction post) {
        this.setTransactionId(post.getId());
        this.setAccountId(post.getAccount().getId());
        this.setOperationTypeId(post.getOperationType().getId());
        this.setAmount(post.getAmount());
        this.setEventDate(post.getEventDate());
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
