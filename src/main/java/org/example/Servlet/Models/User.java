package org.example.Servlet.Models;

import lombok.Data;

@Data
public class User {

    String name;

    int age;

    public User(String name, int age) {
    }
}
