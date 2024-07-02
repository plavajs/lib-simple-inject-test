package com.plavajs.libs.simpleinject;

import com.plavajs.libs.simpleinject.c.C1;
import com.plavajs.libs.simpleinject.annotation.SimpleBean;
import com.plavajs.libs.simpleinject.annotation.SimpleComponentScan;
import com.plavajs.libs.simpleinject.annotation.SimpleConfiguration;

@SimpleConfiguration
@SimpleComponentScan(packages = "com.plavajs.libs.simpleinject")
public class Config03 {

    @SimpleBean(identifier = "simple-bean-C1")
    public static C1 simpleBeanC1() {
        return new C1();
    }

    @SimpleBean(identifier = "simple-bean-C1")
    public static C1 simpleBeanC1Duplicit() {
        return new C1();
    }
}
