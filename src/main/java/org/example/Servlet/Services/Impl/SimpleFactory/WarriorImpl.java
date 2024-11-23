package org.example.Servlet.Services.Impl.SimpleFactory;

import org.example.Servlet.Services.IAdventurer;

public class WarriorImpl implements IAdventurer {
    @Override
    public String getType() {
        System.out.println("我是鬥士");
        return  this.getClass().getSimpleName();
    }
}
