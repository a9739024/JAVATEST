package org.example.Servlet.Models;

import lombok.Data;

@Data
public class Employee {
    private Integer id;

    public Employee(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    private Integer age;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
