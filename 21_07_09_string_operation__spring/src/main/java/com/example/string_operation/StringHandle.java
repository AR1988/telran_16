package com.example.string_operation;

import org.springframework.scheduling.annotation.Async;

import java.io.PrintWriter;

public class StringHandle {

    private final OperationContext operationContext;
    private final PrintWriter printWriter;

//TODO конструтор

    @Async
    public void handleLine(String line) {
//TODO тоже самое что и в handleLine
    }


//    private String handleLine(String line) {
//        String result;
//
//        String[] strings = line.split(SEPARATOR);
//        if (strings.length != 2) {
//            System.out.println(WRONG_FORMAT);
//            return line + " -> " + WRONG_FORMAT;
//        }
//        String stringToOperate = strings[0];
//        String stringOperationName = strings[1];
//
//        IStringOperation operation = operationContext.getOperationByName(stringOperationName);
//
//        if (operation == null) {
//            System.out.println(WRONG_OPERATION);
//            return line + " -> " + WRONG_OPERATION;
//        }
//
//        result = operation.operate(stringToOperate);
//        return result;
//    }
}
