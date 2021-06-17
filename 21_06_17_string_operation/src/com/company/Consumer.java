package com.company;

import com.company.operation.IStringOperation;
import com.company.operation.OperationContext;

import java.io.PrintWriter;
import java.util.List;

public class Consumer implements Runnable {

    private final String SEPARATOR = "#";
//    TODO: exception message as constants here

    private final OperationContext operationContext;
    private final PrintWriter printWriter;
    private final List<String> source;

    public Consumer(OperationContext operationContext, PrintWriter printWriter, List<String> source) {
        this.operationContext = operationContext;
        this.printWriter = printWriter;
        this.source = source;
    }

    @Override
    public void run() {
        for (String s : source) {
            String resultLine = handleLine(s);
            printWriter.println(resultLine);
        }
    }

    private String handleLine(String line) {
        String result;

        String[] strings = line.split(SEPARATOR);
//        TODO check that result.length != 2, then  result = "wrong format"
        String stringToOperate = strings[0];
        String stringOperationName = strings[1];

//        TODO check that operation != null, then result = "wrong operation"
        IStringOperation operation = operationContext.getOperationByName(stringOperationName);

        result = operation.operate(stringToOperate);
        return result;
    }
}
