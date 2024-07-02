package com.plavajs.libs.simpleinject.a;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import lombok.Getter;

@Getter
@SimpleComponent
public class A4 {

    private A5 a5;

    public A4(A5 a5) {
        this.a5 = a5;
    }
}
