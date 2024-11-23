package org.example.Servlet.Bo;

import org.example.Servlet.Services.IStrategy2;

public class PriceCalculator {
    IStrategy2 strategy;

    private PriceCalculator(){};

    public PriceCalculator(IStrategy2 strategy){
        this.strategy = strategy;
    }

    public void setStrategy(IStrategy2 strategy) {
        this.strategy = strategy;
    }

    public int calculate(int km){
        return this.calculate(km,strategy);
    }

    public int calculate(int km , IStrategy2 strategy){
        this.strategy = strategy;
        return strategy.calculate(km);
    }
}
