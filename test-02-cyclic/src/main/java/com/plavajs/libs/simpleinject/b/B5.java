package com.plavajs.libs.simpleinject.b;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class B5 {

    @SimpleInject
    private B2 b2;
}
