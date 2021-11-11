package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class OperationType {

    public static Long COMPRA_A_VISTA = 1L;
    public static Long COMPRA_PARCELADA= 2L;
    public static Long SAQUE = 3L;
    public static Long PAGAMENTO = 4L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Description",nullable = false)
    private String description;

    public OperationType(String compra_a_vista) {
        this.setDescription(compra_a_vista);
    }

    public OperationType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long operationTypeID) {
        this.id = operationTypeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
