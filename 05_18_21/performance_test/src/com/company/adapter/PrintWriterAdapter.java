package com.company.adapter;

import java.io.PrintWriter;

public class PrintWriterAdapter implements IPrintAdapter {

    private final PrintWriter printWriter;

    public PrintWriterAdapter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    @Override
    public void writeLine(String text) {
        printWriter.println(text);
    }

    @Override
    public void closeAdapterStream() {
        printWriter.close();
    }
}
