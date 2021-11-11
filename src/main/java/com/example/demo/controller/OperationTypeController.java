package main.java.com.example.demo.controller;

import main.java.com.example.demo.dtos.ErrorDtoResponse;
import main.java.com.example.demo.dtos.TransactionDtoResponse;
import main.java.com.example.demo.entity.OperationType;
import main.java.com.example.demo.exceptions.TransactionValidadorException;
import main.java.com.example.demo.requestbody.TransactionRequestBody;
import main.java.com.example.demo.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OperationTypeController {

    @Autowired
    OperationTypeService operationTypeService;

    @RequestMapping(value = "/insert-operationstype", method = RequestMethod.POST)
    public void post() {
        operationTypeService.insertOperationsType();
    }
}
