package main.java.com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Document_Number",nullable = false)
    private Long document_number;

    public Account(Long document_number) {
        this.document_number = document_number;
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
