package com.plavajs.libs.simpleinject.a;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import lombok.Getter;

@Getter
@SimpleComponent
public class A2 {

    private A3 a3;

    private A4 a4;

    public A2(A3 a3, A4 a4) {
        this.a3 = a3;
        this.a4 = a4;
    }
}
