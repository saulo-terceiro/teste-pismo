package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class OperationType {

    public static Long COMPRA_A_VISTA = 1L;
    public static Long COMPRA_PARCELADA= 2L;
    public static Long SAQUE = 3L;
    public static Long PAGAMENTO = 4L;

    public static String TIPO_DEBITO = "D";
    public static String TIPO_CREDITO = "C";



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Description",nullable = false)
    private String description;

    @Column(name = "Tipo",nullable = false)
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public OperationType(String description, String tipo) {
        this.description = description;
        this.tipo = tipo;
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
