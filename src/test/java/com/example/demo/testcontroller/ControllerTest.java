package test.java.com.example.demo.testcontroller;

import main.java.com.example.demo.DemoApplication;
import main.java.com.example.demo.controller.AccountController;
import main.java.com.example.demo.controller.TransactionController;
import main.java.com.example.demo.dtos.AccountResponseDto;
import main.java.com.example.demo.dtos.TransactionDtoResponse;
import main.java.com.example.demo.entity.Account;
import main.java.com.example.demo.entity.OperationType;
import main.java.com.example.demo.requestbody.TransactionRequestBody;
import main.java.com.example.demo.service.OperationTypeService;
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

    @Test
    public void testAccountController(){
        Account account = new Account(1293819839L);
        AccountResponseDto accountResponseDto1 = (AccountResponseDto) accountController.post(account).getBody();
        assertTrue(accountResponseDto1.getDocumentation_number().equals(1293819839L));
        AccountResponseDto accountResponseDto2 = (AccountResponseDto) accountController.get(accountResponseDto1.getIdAccount()).getBody();
        assertTrue(accountResponseDto2.getDocumentation_number().equals(1293819839L));
        assertTrue( accountController.get(3L).getStatusCode()== HttpStatus.BAD_REQUEST);
    }


    @Test
    public void testTransactionController(){

//        this.operationTypeService.insertOperationsType();

        Account account = new Account(1293819L);
        AccountResponseDto accountResponseDto1 = (AccountResponseDto) accountController.post(account).getBody();

        TransactionRequestBody transactionRequestBody = new TransactionRequestBody(accountResponseDto1.getIdAccount(),OperationType.COMPRA_A_VISTA,45);
        TransactionDtoResponse transactionDtoResponse = (TransactionDtoResponse) transactionController.post(transactionRequestBody).getBody();
        assertTrue(transactionDtoResponse.getTransactionId().equals(1L));
        assertTrue(transactionDtoResponse.getAccountId().equals(accountResponseDto1.getIdAccount()));
        assertTrue(transactionDtoResponse.getAmount()==-45);
        assertTrue(transactionDtoResponse.getOperationTypeId().equals(OperationType.COMPRA_A_VISTA));
        TransactionRequestBody transactionRequestBody2 = new TransactionRequestBody(accountResponseDto1.getIdAccount()+1,OperationType.COMPRA_A_VISTA,45);
        TransactionRequestBody transactionRequestBody3 = new TransactionRequestBody(accountResponseDto1.getIdAccount()+1,OperationType.PAGAMENTO+1,45);
        TransactionRequestBody transactionRequestBody4 = new TransactionRequestBody(accountResponseDto1.getIdAccount()+1,OperationType.PAGAMENTO+1,-45);

        assertTrue( transactionController.post(transactionRequestBody2).getStatusCode()== HttpStatus.BAD_REQUEST);
        assertTrue( transactionController.post(transactionRequestBody3).getStatusCode()== HttpStatus.BAD_REQUEST);
        assertTrue( transactionController.post(transactionRequestBody4).getStatusCode()== HttpStatus.BAD_REQUEST);





    }

}
