package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Document_Number",nullable = false)
    private Long document_number;

    @Column(name = "Credit_Limit", nullable = false)
    private float credit_limit;

    public float getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(float credit_limit) {
        this.credit_limit = credit_limit;
    }

    public Account(Long document_number, float credit_limit) {
        this.document_number = document_number;
        this.credit_limit = credit_limit;
    }

    public Account() {

    }

    public long getId() {
        return id;
    }

    public void setId(long accountId) {
        this.id = accountId;
    }

    public Long getDocument_number() {
        return document_number;
    }

    public void setDocument_number(Long document_Number) {
        this.document_number = document_Number;
    }
}
