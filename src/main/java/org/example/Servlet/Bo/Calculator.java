package org.example.Servlet.Bo;

import org.example.Servlet.Services.IStrategy;
import org.example.Servlet.Services.Impl.Stractegy.AddStrategyImpl;
import org.example.Servlet.Services.Impl.Stractegy.DivideStrategyImpl;
import org.example.Servlet.Services.Impl.Stractegy.MinusStrategyImpl;
import org.example.Servlet.Services.Impl.Stractegy.MultiplyStrategyImpl;

public class Calculator {

    private int now = 0 ;

    private IStrategy strategy ;

    //    策略模式
    public int execute(int a , int b){
        return strategy.caculate(a,b);
    }

    public void reset(){
        this.now = 0 ;
    }

    //    簡單工廠模式
    public void setStrategy(DoType doType) {
        switch (doType){
            case ADD:
                this.strategy = new AddStrategyImpl();
                break;
            case MINUS:
                this.strategy = new MinusStrategyImpl();
                break;
            case DIVIDE:
                this.strategy = new DivideStrategyImpl();
                break;
            case MULTIPLY:
                this.strategy = new MultiplyStrategyImpl();
                break;
        }
    }

    enum DoType{
        ADD , MINUS , DIVIDE , MULTIPLY
    }
}
