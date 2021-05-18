package com.company;

import com.company.adapter.*;

import java.io.*;

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

        System.out.println("Buffered writer: " + testWriteToFileBwa.test(filePath, 1000_000));
        System.out.println("Print writer: " + testWriteToFilePra.test(filePath, 1000_000));

        System.out.println("Print stream writer: " + testWriteToFilePsa.test(filePath, 1000_000));
        System.out.println("File output stream writer: " + testWriteToFileFpsa.test(filePath, 1000_000));
    }
}
