package com.company;

import com.company.helper.ConfigReader;
import com.company.operation.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application {

    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConfigReader configReader = new ConfigReader("config.props");
        List<String> operationPaths = configReader.getOperationsPaths();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT));
        PrintWriter writer = new PrintWriter(new FileOutputStream(OUTPUT));

        BlockingQueue<String> source = new LinkedBlockingQueue<>();
        Supplier supplier = new Supplier(source, bufferedReader);
        Thread supplierThread = new Thread(supplier);
        supplierThread.start();
        supplierThread.join();

        OperationContext operationContext = new OperationContext(operationPaths);
        Consumer consumer = new Consumer(operationContext, writer, source);
        List<Thread> consumerThreads = Arrays.asList(
                new Thread(consumer),
                new Thread(consumer),
                new Thread(consumer),
                new Thread(consumer),
                new Thread(consumer)
        );

        for (Thread thread : consumerThreads)
            thread.start();

        for (Thread thread : consumerThreads)
            thread.join();

        bufferedReader.close();

        writer.flush();
        writer.close();
    }
}
