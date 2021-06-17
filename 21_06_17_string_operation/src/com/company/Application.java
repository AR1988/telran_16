package com.company;

import com.company.helper.ConfigReader;
import com.company.operation.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConfigReader configReader = new ConfigReader("config.props");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT));
        PrintWriter writer = new PrintWriter(new FileOutputStream(OUTPUT));
        List<String> source = new ArrayList<>();

        List<String> operationPaths = configReader.getOperationsPaths();
        OperationContext operationContext = new OperationContext(operationPaths);

        Supplier supplier = new Supplier(source, bufferedReader);
        Thread supplierThread = new Thread(supplier);
        supplierThread.start();
        supplierThread.join();

        Consumer consumer = new Consumer(operationContext, writer, source);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        consumerThread.join();

        bufferedReader.close();
        writer.close();

        System.out.println(source);
    }
}
