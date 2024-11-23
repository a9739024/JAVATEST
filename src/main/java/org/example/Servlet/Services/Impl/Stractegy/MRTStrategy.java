package org.example.Servlet.Services.Impl.Stractegy;

import org.example.Servlet.Services.IStrategy2;

public class MRTStrategy implements IStrategy2 {
    @Override
    public int calculate(int km) {
        //小於十公里20元，超過每五公里多五元
        int result = 0 ;
        if(km <= 0) return  result ;

        if(km <= 10) {
            result = 20 ;
        }

        if(km > 10){
            int count = (int)Math.ceil((((double)km - 10) / 5));
            result = 20 + 5 * count ;
        }
        return result;
    }
}
