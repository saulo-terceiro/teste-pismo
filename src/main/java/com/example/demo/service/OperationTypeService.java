package com.example.demo.service;

import com.example.demo.entity.OperationType;
import org.springframework.stereotype.Service;

@Service
public interface OperationTypeService {

     public OperationType getOperationType(Long id);

     public void saveOperationType(OperationType operationType);

    void insertOperationsType();
}
