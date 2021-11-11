package com.example.demo.controller;

import com.example.demo.dtos.ErrorDtoResponse;
import com.example.demo.dtos.TransactionDtoResponse;
import com.example.demo.exceptions.TransactionValidadorException;
import com.example.demo.requestbody.TransactionRequestBody;
import com.example.demo.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public ResponseEntity<Object> post(@RequestBody TransactionRequestBody transactionRequestBody) {
        try {
            TransactionDtoResponse transactionDtoResponse = new TransactionDtoResponse(transactionService.post(transactionRequestBody));
            return ResponseEntity.ok(transactionDtoResponse);
        }catch (TransactionValidadorException t){
            ErrorDtoResponse errorDtoResponse = new ErrorDtoResponse(t.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDtoResponse);
        }
    }
}
