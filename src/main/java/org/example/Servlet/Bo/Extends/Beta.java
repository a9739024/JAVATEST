package org.example.Servlet.Bo.Extends;

public class Beta extends Alpha {

    public void foo() {
        System.out.println("Bfoo ");
    }

    public static void main(String[] args){
        Alpha alpha = new Beta();
        Beta beta = (Beta) alpha;
        alpha.foo();
        beta.foo();
    }
}
