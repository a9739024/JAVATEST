package org.example.Servlet.Services.Impl.SimpleFactory;

import org.example.Servlet.Services.IAdventurer;

public class ArcherImpl implements IAdventurer {
    @Override
    public String getType() {
        System.out.println("我是弓箭手");
        return this.getClass().getSimpleName();
    }
}
