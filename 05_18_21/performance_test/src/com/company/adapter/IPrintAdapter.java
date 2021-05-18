package com.company.adapter;

import java.io.IOException;

public interface IPrintAdapter {

    void writeLine(String text);

    void closeAdapterStream();
}
