package org.example.Servlet.Controller;

public class Singleton {
    public Singleton() {}
    private static volatile Singleton instance;
    public static Singleton getInstance(){
            if(instance == null){
                synchronized(Singleton.class){
                    instance = new Singleton();
                }
            }

            return instance;
    }
}
