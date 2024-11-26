package org.example.Servlet.Controller;

public class SingletonTest {
   private volatile SingletonTest instance;

   public SingletonTest getInstance(){
       if(instance == null){
           synchronized(SingletonTest.class){
               instance = new SingletonTest();
           }
       }
       return instance;
   }
}
