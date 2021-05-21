package com.company.adapter.interfaces;

import java.io.IOException;

public interface IPrintAdapter {

    void writeLine(String text);

    void closeAdapterStream();
}
