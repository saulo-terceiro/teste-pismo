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
            OperationType operationTypeCompraAVista = new OperationType("COMPRA A VISTA",OperationType.TIPO_DEBITO);
            OperationType operationTypeCompraParcelada = new OperationType("COMPRA PARCELADA",OperationType.TIPO_DEBITO);
            OperationType operationTypeSaque = new OperationType("SAQUE",OperationType.TIPO_DEBITO);
            OperationType operationTypePagamento = new OperationType("PAGAMENTO",OperationType.TIPO_CREDITO);
            this.saveOperationType(operationTypeCompraAVista);
            this.saveOperationType(operationTypeCompraParcelada);
            this.saveOperationType(operationTypeSaque);
            this.saveOperationType(operationTypePagamento);
        }

    }


}
