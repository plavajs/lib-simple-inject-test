package com.plavajs.libs.simpleinject;

import com.plavajs.libs.simpleinject.c.C1;
import com.plavajs.libs.simpleinject.exception.DuplicitBeansException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContext03Test {
    
    @Test
    void c1_throws() {
        try {
            ApplicationContext.getInstance(C1.class);
        } catch (ExceptionInInitializerError e) {
            assertEquals(DuplicitBeansException.class, e.getCause().getClass());
        }
    }
}