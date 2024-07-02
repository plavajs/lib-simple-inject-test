package com.plavajs.libs.simpleinject.c;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class C3 {

    @SimpleInject
    private C4 c4;

    private C5 c5;

    public C3(C5 c5) {
        this.c5 = c5;
    }
}
