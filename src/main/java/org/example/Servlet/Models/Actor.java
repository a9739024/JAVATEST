package org.example.Servlet.Models;

import lombok.Data;

@Data
public class Actor {

    private String name;

    private int age;

    public Actor(String s, Integer s1) {
        name = s;
        age = s1;
    }
}
