package org.example.Servlet.Services.Impl.HorseLike;

import org.example.Servlet.Services.HorseLike;

//interface只能使用implements繼承
//public class Clot extends HorseLike {
public class Clot implements HorseLike {

    public String ride() {
        return "tolting";
    }

}
