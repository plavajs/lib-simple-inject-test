package com.plavajs.libs.simpleinject.d;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class D3 {

    @SimpleInject
    private D4 d4;

    @SimpleInject
    private D5 d5;
}
