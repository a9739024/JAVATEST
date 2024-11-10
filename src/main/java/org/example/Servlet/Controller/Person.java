package org.example.Servlet.Controller;

public class Person {

    String name;

    public Person(String name) {this.name = name;}

    public String getName() {return name;}

    class Empolyee extends Person{

        public Empolyee(String name) {
            super(name);
        }
    }
}
