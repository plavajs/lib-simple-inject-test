package com.plavajs.libs.simpleinject.b;

import com.plavajs.libs.simpleinject.annotation.SimpleBean;
import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import lombok.Getter;

@Getter
@SimpleComponent
public class B5 {

    @SimpleBean
    public B5() {
    }

    @SimpleBean
    public B5(String hello) {
        System.out.println(hello);
    }
}
