package com.company;

import com.company.operation.OperationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;

public class Supplier implements Runnable {

    private final BufferedReader br;
    private final ExecutorService executorService;
    private final OperationContext operationContext;
    private final PrintWriter printWriter;


    public Supplier(BufferedReader br,
                    PrintWriter printWriter,
                    ExecutorService executorService,
                    OperationContext operationContext) {
        this.br = br;
        this.executorService = executorService;
        this.operationContext = operationContext;
        this.printWriter = printWriter;
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                Runnable task = new Consumer(operationContext, printWriter, line);
                executorService.execute(task);
            }
            System.out.println("END");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
