package com.plavajs.libs.simpleinject;

import com.plavajs.libs.simpleinject.a.A1;
import com.plavajs.libs.simpleinject.a.A2;
import com.plavajs.libs.simpleinject.annotation.SimpleBean;
import com.plavajs.libs.simpleinject.annotation.SimpleComponentScan;
import com.plavajs.libs.simpleinject.annotation.SimpleConfiguration;
import com.plavajs.libs.simpleinject.b.B1;
import com.plavajs.libs.simpleinject.c.C1;
import com.plavajs.libs.simpleinject.d.D1;
import com.plavajs.libs.simpleinject.e.E1;

@SimpleConfiguration
@SimpleComponentScan(packages = "com.plavajs.libs.simpleinject")
public class Config02 {

    @SimpleBean(identifier = "simple-bean-A1")
    public static A1 simpleBeanA1(A2 a2) {
        return new A1(a2);
    }

    @SimpleBean(identifier = "simple-bean-B1")
    public static B1 simpleBeanB1() {
        return new B1();
    }

    @SimpleBean(identifier = "simple-bean-C1")
    public static C1 simpleBeanC1() {
        return new C1();
    }

    @SimpleBean(identifier = "simple-bean-D1")
    public static D1 simpleBeanD1() {
        return new D1();
    }

    @SimpleBean(identifier = "simple-bean-E1")
    public static E1 simpleBeanE1() {
        return new E1();
    }
}
