package com.plavajs.libs.simpleinject.d;

import com.plavajs.libs.simpleinject.annotation.SimpleBean;
import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import lombok.Getter;

@Getter
@SimpleComponent
public class D5 {

    public D5() { }

    public D5(String hello) {
        System.out.println(hello);
    }
}
