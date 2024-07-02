package com.plavajs.libs.simpleinject.d;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class D1 {

    @SimpleInject
    private D2 d2;

}
