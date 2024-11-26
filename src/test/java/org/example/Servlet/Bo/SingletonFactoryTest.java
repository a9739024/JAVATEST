package org.example.Servlet.Bo;

import org.slf4j.Logger;

class SingletonFactoryTest {

    public static void main(String[] args) {
        Cola cola = (Cola) SingletonFactory.getColaFactory().getProduct();
        Humberger humberger =(Humberger) SingletonFactory.getHumbergerFactory().getProduct();

        System.out.println("可樂name:" + cola.getName());
        System.out.println("漢堡name:" + humberger.getName());
        System.out.println(SingletonFactory.getline(10));

        boolean flag = 10%2 == 1 && 10/3 == 0 && 1/0 == 0;
        System.out.println(flag ? "true":"false");
        String aa = "420";
        aa+=42;
        System.out.println(aa);
        int[] x[] = {{1,2},{3,4,5},{6,7,8,9}};
        int y[][] = x;
        System.out.println(y[2][1]);
    }
}