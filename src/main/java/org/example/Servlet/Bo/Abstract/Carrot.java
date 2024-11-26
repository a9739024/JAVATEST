package org.example.Servlet.Bo.Abstract;

public class Carrot extends Vegetable{

    String grow() {
        return "Down";
    }

    public static void main(String[] args) {
        Vegetable carrot = new Carrot();
        Vegetable v = new Vegetable();
        System.out.println(carrot.grow() + v.grow());
    }
}
