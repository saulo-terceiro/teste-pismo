package main.com.example.demo.controller;

import main.com.example.demo.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
