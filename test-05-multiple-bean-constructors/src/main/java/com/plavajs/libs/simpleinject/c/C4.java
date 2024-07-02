package com.plavajs.libs.simpleinject.c;

import com.plavajs.libs.simpleinject.annotation.SimpleComponent;
import com.plavajs.libs.simpleinject.annotation.SimpleInject;
import lombok.Getter;

@Getter
@SimpleComponent
public class C4 {

    @SimpleInject
    private C5 c5;
}
