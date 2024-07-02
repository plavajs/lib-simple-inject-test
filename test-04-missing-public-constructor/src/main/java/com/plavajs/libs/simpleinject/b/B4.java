package com.plavajs.libs.simpleinject.b;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class B4 {

    @SimpleInject
    private B5 b5;

    private B4() {

    }
}
