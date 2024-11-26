package org.example.Servlet.Controller;

public class SingletonTest2 {

    private static volatile SingletonTest2 instance;
    public static SingletonTest2 getInstance() {
        if (instance == null) {
            synchronized (SingletonTest2.class) {
                if (instance == null) {
                    instance = new SingletonTest2();
                }
            }
        }
        return instance;
    }
}
