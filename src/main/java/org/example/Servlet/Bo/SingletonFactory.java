package org.example.Servlet.Bo;

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
}
