package com.plavajs.libs.simpleinject.d;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class D2 {

    @SimpleInject
    private D3 d3;

    @SimpleInject
    private D4 d4;

}
