package com.example.demo.dtos;


import com.example.demo.entity.Account;

public class AccountResponseDto {
    Long idAccount;
    Long documentation_number;
    float creditLimit;

    public AccountResponseDto(Account account) {
        this.setIdAccount(account.getId());
        this.setDocumentation_number(account.getDocument_number());
        this.setCreditLimit(account.getCredit_limit());

    }

    public float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Long getDocumentation_number() {
        return documentation_number;
    }

    public void setDocumentation_number(Long documentation_number) {
        this.documentation_number = documentation_number;
    }
}
