package com.example.string_operation;

import com.example.string_operation.service.IOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OperationContext {

    private final Map<String, IOperation> operations = new HashMap<>();

    public OperationContext(List<IOperation> operationsList) {
        for (IOperation iOperation : operationsList) {
            operations.put(iOperation.getName(), iOperation);
        }

//        operations = operationsList
//                .stream()
//                .collect(Collectors.toMap(IOperation::getName, iOperation -> iOperation));
    }

    public IOperation getOperationByName(String operationName) {
        return operations.get(operationName);
    }
}
