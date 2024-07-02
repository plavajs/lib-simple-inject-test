package com.plavajs.libs.simpleinject.c;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class C1 {

    @SimpleInject
    private C2 c2;

}
