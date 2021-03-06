package com.example.demo.controller;


import com.example.demo.dtos.AccountResponseDto;
import com.example.demo.dtos.ErrorDtoResponse;
import com.example.demo.entity.Account;
import com.example.demo.exceptions.AccountValidadorException;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public ResponseEntity<Object> post(@RequestBody Account account) {
        try {
            AccountResponseDto accountDtoResponse = new AccountResponseDto(accountService.post(account));
            return ResponseEntity.ok(accountDtoResponse);
        }catch (AccountValidadorException t){
            ErrorDtoResponse errorDtoResponse = new ErrorDtoResponse(t.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDtoResponse);
        }
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable Long accountId) {
        try {
            AccountResponseDto accountDtoResponse = new AccountResponseDto(accountService.get(accountId));
            return ResponseEntity.ok(accountDtoResponse);
        }catch (AccountValidadorException t){
            ErrorDtoResponse errorDtoResponse = new ErrorDtoResponse(t.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDtoResponse);
        }
    }


}
