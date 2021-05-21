package com.company;

import com.company.adapter.*;
import com.company.adapter.interfaces.IPrintAdapter;
import com.company.adapter.interfaces.IReadAdapter;

import java.io.*;
import java.util.Scanner;

public class TestRunner {

    public static void main(String[] args) throws IOException {
        String filePath = "file.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        PrintStream printStream = new PrintStream(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        PrintWriter printWriter = new PrintWriter(filePath);

        IPrintAdapter bwa = new BufferedWriterAdapter(bw);
        IPrintAdapter psa = new PrintStreamAdapter(printStream);
        IPrintAdapter fpsa = new FileOutputPrintStreamAdapter(fileOutputStream);
        IPrintAdapter pra = new PrintWriterAdapter(printWriter);

        TestWriteToFile testWriteToFileBwa = new TestWriteToFile(bwa);
        TestWriteToFile testWriteToFilePsa = new TestWriteToFile(psa);
        TestWriteToFile testWriteToFileFpsa = new TestWriteToFile(fpsa);
        TestWriteToFile testWriteToFilePra = new TestWriteToFile(pra);

        System.out.println("Buffered writer: " + testWriteToFileBwa.test(filePath, 1_0000_0000));
//        System.out.println("Print writer: " + testWriteToFilePra.test(filePath, 1000_000));
//
//        System.out.println("Print stream writer: " + testWriteToFilePsa.test(filePath, 1000_000));
//        System.out.println("File output stream writer: " + testWriteToFileFpsa.test(filePath, 1000_000));

//        Test read file
        IReadAdapter bufferedReaderAdapter = new BufferedReaderAdapter(filePath);
        IReadAdapter inputStreamAdapter = new FileInputStreamAdapter(filePath);

        TestReadFile testRunnerReadBuffered = new TestReadFile(bufferedReaderAdapter);
        TestReadFile testInputStream = new TestReadFile(inputStreamAdapter);

        System.out.println("buffered reader: " + testRunnerReadBuffered.test());
        System.out.println("file input stream : " + testInputStream.test());

        Scanner scanner = new Scanner(System.in);
        String line;
        StringBuilder bf = new StringBuilder();
        while (!(line = scanner.nextLine()).equals("q")) {
            bf.append(line);
        }

        String hi = scanner.nextLine();
        String java = scanner.nextLine();
        bf.append(hi).append(java);

        System.out.println(bf);
        scanner.close();
    }
}
