package com.company;

import com.company.helper.ConfigReader;
import com.company.operation.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ConfigReader configReader = new ConfigReader("config.props");
        List<String> operationPaths = configReader.getOperationsPaths();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT));
        PrintWriter writer = new PrintWriter(new FileOutputStream(OUTPUT));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        OperationContext operationContext = new OperationContext(operationPaths);

        Supplier supplier = new Supplier(bufferedReader, writer, executorService, operationContext);
        Thread supplierThread = new Thread(supplier);
        supplierThread.start();
        supplierThread.join();

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("END App");

        bufferedReader.close();
        writer.close();
    }
}
