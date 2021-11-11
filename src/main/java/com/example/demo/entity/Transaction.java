package main.java.com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private OperationType operationType;

    @Column(name = "Amount")
    private float amount;

    @Column(name = "Event_Date")
    private Date eventDate;



    public Transaction(Account account, OperationType operationType, float amount, Date eventDate) {
        this.account = account;
        this.operationType = operationType;
        this.amount = amount;
        this.eventDate = eventDate;
    }

    public Transaction(Long idAccount, Long compraAVista, int amount) {
    }

    public Transaction() {

    }

    public long getId() {
        return id;
    }

    public void setId(long transactionId) {
        this.id = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
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
