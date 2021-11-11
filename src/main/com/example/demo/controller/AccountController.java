package main.com.example.demo.controller;

import main.com.example.demo.entity.Account;
import main.com.example.demo.service.AccountService;
import main.com.example.demo.dtos.AccountResponseDto;
import main.com.example.demo.dtos.ErrorDtoResponse;
import main.com.example.demo.exceptions.AccountValidadorException;
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
