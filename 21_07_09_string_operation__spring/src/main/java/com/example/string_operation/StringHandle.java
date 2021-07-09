package com.example.string_operation;

import com.example.string_operation.service.IOperation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Component
public class StringHandle {

    private final String WRONG_OPERATION = "Wrong operation";
    private final String WRONG_FORMAT = "Wrong format";
    private final String SEPARATOR = "#";

    private final OperationContext operationContext;
    private final PrintWriter printWriter;

    public StringHandle(OperationContext operationContext, PrintWriter printWriter) {
        this.operationContext = operationContext;
        this.printWriter = printWriter;
    }

    @Async
    public void handleLine(String line) {
        String res = handleRawString(line);
        System.out.println(Thread.currentThread().getName());
        printWriter.println(res);
        printWriter.flush();
    }

    private String handleRawString(String line) {
        String result;

        String[] strings = line.split(SEPARATOR);
        if (strings.length != 2) {
            System.out.println(WRONG_FORMAT);
            return line + " -> " + WRONG_FORMAT;
        }
        String stringToOperate = strings[0];
        String stringOperationName = strings[1];

        IOperation operation = operationContext.getOperationByName(stringOperationName);

        if (operation == null) {
            System.out.println(WRONG_OPERATION);
            return line + " -> " + WRONG_OPERATION;
        }

        result = operation.operate(stringToOperate);
        return result;
    }
}
