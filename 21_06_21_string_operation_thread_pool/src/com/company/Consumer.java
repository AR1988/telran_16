package com.company;

import com.company.operation.IStringOperation;
import com.company.operation.OperationContext;

import java.io.PrintWriter;

public class Consumer implements Runnable {

    private static final String WRONG_FORMAT = "ERROR! wrong format";
    private static final String WRONG_OPERATION = "ERROR! wrong operation";
    private final String SEPARATOR = "#";

    private final OperationContext operationContext;
    private final PrintWriter printWriter;
    private final String source;

    public Consumer(OperationContext operationContext, PrintWriter printWriter, String source) {
        this.operationContext = operationContext;
        this.printWriter = printWriter;
        this.source = source;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " line: " + source);
        String resultLine = handleLine(source);
        printWriter.println(resultLine);
    }

    private String handleLine(String line) {
        String result;

        String[] strings = line.split(SEPARATOR);
        if (strings.length != 2) {
            System.out.println(WRONG_FORMAT);
            return line + " -> " + WRONG_FORMAT;
        }
        String stringToOperate = strings[0];
        String stringOperationName = strings[1];

        IStringOperation operation = operationContext.getOperationByName(stringOperationName);

        if (operation == null) {
            System.out.println(WRONG_OPERATION);
            return line + " -> " + WRONG_OPERATION;
        }

        result = operation.operate(stringToOperate);
        return result;
    }
}
