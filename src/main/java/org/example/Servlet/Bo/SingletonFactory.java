package org.example.Servlet.Bo;

import org.example.Servlet.Controller.AjaxTestServlet;
import org.example.Servlet.Services.IFactory;
import org.example.Servlet.Services.IProduct;

public class SingletonFactory {

    public static IFactory getColaFactory() {
        return ColaFactory.colaFactory;
    }

    public static IFactory getHumbergerFactory() {
        return HumbergerFactory.humbergerFactory;
    }

    private static class ColaFactory implements IFactory{

        private static ColaFactory colaFactory = new ColaFactory();

        private ColaFactory(){}

        @Override
        public IProduct getProduct() {
            return new Cola();
        }
    }

    private static class HumbergerFactory implements IFactory{

        private static HumbergerFactory humbergerFactory = new HumbergerFactory();

        private HumbergerFactory(){}

        @Override
        public IProduct getProduct() {
            return new Humberger();
        }
    }

    public static String getline(int n){
        StringBuilder line = new StringBuilder();
        double dd = Math.pow(2, n - 1);
        double total = 0;
        line.append("(").append(n).append("). ");
        for(int y = 1; y <= n; y++) {
            total+=dd;
            line.append((int)dd).append("+");
        }
        line.deleteCharAt(line.length()-1);
        line.append("=").append((int)total);

        return line.toString();
    }

}
