package com.company;


import com.company.adapter.IPrintAdapter;

public class TestWriteToFile {

    private final IPrintAdapter adapter;

    public TestWriteToFile(IPrintAdapter adapter) {
        this.adapter = adapter;
    }

    public long test(String text, int length) {
        long start = System.currentTimeMillis();

        for (int i = 1; i <= length; i++)
            adapter.writeLine(text);

        adapter.closeAdapterStream();
        adapter.closeAdapterStream();

        long end = System.currentTimeMillis();
        return end - start;
    }
}
