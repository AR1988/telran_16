package com.company.operation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationContext {

    private final Map<String, IStringOperation> operations = new HashMap<>();

    public OperationContext(List<String> operationPaths) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (String operationPath : operationPaths) {
            IStringOperation operation = loadOperation(operationPath);
            operations.put(operation.getName(), operation);
        }
    }

    private IStringOperation loadOperation(String operationPath) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (IStringOperation) Class
                .forName(operationPath)
                .getConstructor()
                .newInstance();
    }

    public IStringOperation getOperationByName(String operationName) {
        return operations.get(operationName);
    }
}
