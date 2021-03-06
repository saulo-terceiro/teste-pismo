package com.example.demo.testcontroller;


import com.example.demo.DemoApplication;
import com.example.demo.controller.AccountController;
import com.example.demo.controller.TransactionController;
import com.example.demo.dtos.AccountResponseDto;
import com.example.demo.dtos.TransactionDtoResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.OperationType;
import com.example.demo.requestbody.TransactionRequestBody;
import com.example.demo.service.OperationTypeService;
import com.example.demo.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ControllerTest {

    @Autowired
    AccountController accountController;

    @Autowired
    TransactionController transactionController;

    @Autowired
    OperationTypeService operationTypeService;

    @Autowired
    TransactionService transactionService;

    @Test
    public void testAccountController(){
        Account account = new Account(1293819839L,1000);
        AccountResponseDto accountResponseDto1 = (AccountResponseDto) accountController.post(account).getBody();
        assertTrue(accountResponseDto1.getDocumentation_number().equals(1293819839L));
        assertTrue(accountResponseDto1.getCreditLimit()==1000);
        AccountResponseDto accountResponseDto2 = (AccountResponseDto) accountController.get(accountResponseDto1.getIdAccount()).getBody();
        assertTrue(accountResponseDto2.getDocumentation_number().equals(1293819839L));
        assertTrue( accountController.get(3L).getStatusCode()== HttpStatus.BAD_REQUEST);

        Account account2 = new Account(1293819839L,-1000);
        assertTrue( accountController.post(account2).getStatusCode()== HttpStatus.BAD_REQUEST);

    }


    @Test
    public void testTransactionController(){

//        this.operationTypeService.insertOperationsType();

        Account account = new Account(1293819L,2000);
        AccountResponseDto accountResponseDto1 = (AccountResponseDto) accountController.post(account).getBody();

        TransactionRequestBody transactionRequestBody = new TransactionRequestBody(accountResponseDto1.getIdAccount(),OperationType.COMPRA_A_VISTA,45);
        TransactionDtoResponse transactionDtoResponse = (TransactionDtoResponse) transactionController.post(transactionRequestBody).getBody();
        assertTrue(transactionDtoResponse.getTransactionId().equals(1L));
        assertTrue(transactionDtoResponse.getAccountId().equals(accountResponseDto1.getIdAccount()));
        assertTrue(transactionDtoResponse.getAmount()==-45);
        assertTrue(transactionDtoResponse.getOperationTypeId().equals(OperationType.COMPRA_A_VISTA));

        TransactionRequestBody transactionRequestBody5 = new TransactionRequestBody(accountResponseDto1.getIdAccount(),OperationType.PAGAMENTO,55);
        TransactionDtoResponse transactionDtoResponse2 = (TransactionDtoResponse) transactionController.post(transactionRequestBody5).getBody();
        assertTrue(transactionDtoResponse2.getTransactionId().equals(2L));
        assertTrue(transactionDtoResponse2.getAccountId().equals(accountResponseDto1.getIdAccount()));
        assertTrue(transactionDtoResponse2.getAmount()==55);
        assertTrue(transactionDtoResponse2.getOperationTypeId().equals(OperationType.PAGAMENTO));
        TransactionRequestBody transactionRequestBody2 = new TransactionRequestBody(accountResponseDto1.getIdAccount()+1,OperationType.COMPRA_A_VISTA,45);
        TransactionRequestBody transactionRequestBody3 = new TransactionRequestBody(accountResponseDto1.getIdAccount()+1,OperationType.PAGAMENTO+1,45);
        TransactionRequestBody transactionRequestBody4 = new TransactionRequestBody(accountResponseDto1.getIdAccount()+1,OperationType.PAGAMENTO+1,-45);

        assertTrue( transactionController.post(transactionRequestBody2).getStatusCode()== HttpStatus.BAD_REQUEST);
        assertTrue( transactionController.post(transactionRequestBody3).getStatusCode()== HttpStatus.BAD_REQUEST);
        assertTrue( transactionController.post(transactionRequestBody4).getStatusCode()== HttpStatus.BAD_REQUEST);



    }

    @Test
    public void testTransacoesSaldo(){
        Account account1 = new Account(12938192L,100);
        accountController.post(account1);

        TransactionRequestBody transactionRequestBody1 = new TransactionRequestBody(account1.getId(),OperationType.COMPRA_A_VISTA,101);
        assertTrue(transactionController.post(transactionRequestBody1).getStatusCode()== HttpStatus.BAD_REQUEST);

        TransactionRequestBody transactionRequestBody2 = new TransactionRequestBody(account1.getId(),OperationType.COMPRA_A_VISTA,90);
        transactionController.post(transactionRequestBody2);
        assertTrue(transactionService.getSaldoDisponivel(account1.getId())==10);

        TransactionRequestBody transactionRequestBody3 = new TransactionRequestBody(account1.getId(),OperationType.SAQUE,15);

        assertTrue(transactionController.post(transactionRequestBody3).getStatusCode()== HttpStatus.BAD_REQUEST);

        TransactionRequestBody transactionRequestBody4 = new TransactionRequestBody(account1.getId(),OperationType.PAGAMENTO,20);

        transactionController.post(transactionRequestBody4);
        assertTrue(transactionService.getSaldoDisponivel(account1.getId())==30);

        TransactionDtoResponse transactionDtoResponse2 = (TransactionDtoResponse) transactionController.post(transactionRequestBody3).getBody();
        assertTrue(transactionService.getSaldoDisponivel(account1.getId())==15);



    }

}
