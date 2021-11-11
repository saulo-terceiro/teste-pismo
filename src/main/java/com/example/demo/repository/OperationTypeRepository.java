package main.java.com.example.demo.repository;

import main.java.com.example.demo.entity.OperationType;
import org.springframework.data.repository.CrudRepository;

public interface OperationTypeRepository extends CrudRepository<OperationType,Long> {
}
