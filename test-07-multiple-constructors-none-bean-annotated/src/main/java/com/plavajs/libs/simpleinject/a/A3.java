package com.plavajs.libs.simpleinject.a;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import lombok.Getter;

@Getter
@SimpleComponent
public class A3 {

    private A4 a4;

    private A5 a5;

    public A3(A4 a4, A5 a5) {
        this.a4 = a4;
        this.a5 = a5;
    }
}
