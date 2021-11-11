package main.com.example.demo.component;

import main.com.example.demo.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OperationTypeComponent {

    @Autowired
    OperationTypeService operationTypeService;

    @EventListener
    public void adicionarOperationsType(ContextRefreshedEvent event){
        this.operationTypeService.insertOperationsType();
    }
}
