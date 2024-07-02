package com.plavajs.libs.simpleinject.b;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class B2 {

    @SimpleInject
    private B3 b3;

    @SimpleInject
    private B4 b4;

}
