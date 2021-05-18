package com.company.adapter;

import java.io.PrintStream;

public class PrintStreamAdapter implements IPrintAdapter {

    private final PrintStream printStream;

    public PrintStreamAdapter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void writeLine(String text) {
        printStream.println(text);
    }

    @Override
    public void closeAdapterStream() {
        printStream.close();
    }
}
