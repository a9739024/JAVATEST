package org.example.Servlet.Bo;

public class BatMan {

    int sq = 81;

    public static void main(String[] args){
        new BatMan().go();
    }

    void go(){
        incr(++sq);
        System.out.println(sq);
    }

    void incr(int sq){
        System.out.println("incr" + sq);
        sq += 10;
        System.out.println("After" + sq);
    }
}
