package main.com.example.demo.dtos;

import main.com.example.demo.entity.Account;

public class AccountResponseDto {
    Long idAccount;
    Long documentation_number;
    public AccountResponseDto(Account account) {
        this.setIdAccount(account.getId());
        this.setDocumentation_number(account.getDocument_number());
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
