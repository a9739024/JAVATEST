package org.example.Servlet.Controller;

public class SingletonTest {
    public SingletonTest(){};
    private static volatile SingletonTest instance;
    public static SingletonTest getInstance() {
        if(instance == null) {
            synchronized(SingletonTest.class) {
                instance = new SingletonTest();
            }
        }
        return instance;
    }
}
