package com.example.demo.service;


import com.example.demo.entity.OperationType;
import com.example.demo.repository.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OperationTypeServiceImpl implements OperationTypeService{

    @Autowired
    OperationTypeRepository operationTypeRepository;

    @Override
    public OperationType getOperationType(Long id) {
        return operationTypeRepository.findById(id).get();
    }

    @Override
    public void saveOperationType(OperationType operationType) {
        operationTypeRepository.save(operationType);
    }

    @Override
    public void insertOperationsType() {
        try{
            getOperationType(1L);
        }catch (NoSuchElementException n){
            OperationType operationTypeCompraAVista = new OperationType("COMPRA A VISTA");
            OperationType operationTypeCompraParcelada = new OperationType("COMPRA PARCELADA");
            OperationType operationTypeSaque = new OperationType("SAQUE");
            OperationType operationTypePagamento = new OperationType("PAGAMENTO");
            this.saveOperationType(operationTypeCompraAVista);
            this.saveOperationType(operationTypeCompraParcelada);
            this.saveOperationType(operationTypeSaque);
            this.saveOperationType(operationTypePagamento);
        }

    }


}
