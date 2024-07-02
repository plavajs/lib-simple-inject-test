package com.plavajs.libs.simpleinject.c;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class C2 {

    private C3 c3;

    @SimpleInject
    private C4 c4;

    public C2(C3 c3) {
        this.c3 = c3;
    }

}
