package org.example.Servlet.Bo;

import org.slf4j.Logger;

class SingletonFactoryTest {

    public static void main(String[] args) {
        Cola cola = (Cola) SingletonFactory.getColaFactory().getProduct();
        Humberger humberger =(Humberger) SingletonFactory.getHumbergerFactory().getProduct();

        System.out.println("可樂name:" + cola.getName());
        System.out.println("漢堡name:" + humberger.getName());

    }
}