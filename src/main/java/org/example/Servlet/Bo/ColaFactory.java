package org.example.Servlet.Bo;

import org.example.Servlet.Services.IFactory;
import org.example.Servlet.Services.IProduct;
import org.testng.annotations.Factory;

public class ColaFactory implements IFactory {
    private static ColaFactory colaFactory = new ColaFactory();

    private ColaFactory(){}

    @Override
    public IProduct getProduct() {
        return new Cola();
    }
}
