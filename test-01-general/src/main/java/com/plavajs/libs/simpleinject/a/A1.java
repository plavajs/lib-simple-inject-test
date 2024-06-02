package com.plavajs.libs.simpleinject.a;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import lombok.Getter;

@Getter
@SimpleComponent
public class A1 {

    private A2 a2;

    public A1(A2 a2) {
        this.a2 = a2;
    }
}
