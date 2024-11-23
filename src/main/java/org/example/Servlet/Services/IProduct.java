package org.example.Servlet.Services;

public abstract class IProduct {
    public String getName(){
        return this.getClass().getSimpleName();
    }
}
