package org.example.Servlet.Services.Impl.Stractegy;

import org.example.Servlet.Services.IStrategy;

public class MinusStrategyImpl implements IStrategy {

    @Override
    public int caculate(int a, int b) {
        return a - b ;
    }
}
