package com.company;

import com.company.adapter.interfaces.IReadAdapter;

public class TestReadFile {

    IReadAdapter iReadAdapter;

    public TestReadFile(IReadAdapter iReadAdapter) {
        this.iReadAdapter = iReadAdapter;
    }

    public long test() {
        long start = System.currentTimeMillis();

        iReadAdapter.readLine();
        iReadAdapter.close();

        long end = System.currentTimeMillis();
        return end - start;
    }
}
