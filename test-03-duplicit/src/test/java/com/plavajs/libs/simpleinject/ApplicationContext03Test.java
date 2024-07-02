package com.plavajs.libs.simpleinject;

import com.plavajs.libs.simpleinject.a.*;
import com.plavajs.libs.simpleinject.b.*;
import com.plavajs.libs.simpleinject.c.*;
import com.plavajs.libs.simpleinject.exception.DuplicitBeansException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContext03Test {

    @Test
    void a_components_throws() {
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(A1.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(A1.class, "simple-bean-A1"));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(A2.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(A3.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(A4.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(A5.class));
    }

    @Test
    void b_injects_throws() {
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(B1.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(B1.class, "simple-bean-B1"));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(B2.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(B3.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(B4.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(B5.class));
    }

    @Test
    void c_componentsInjects_throws() {
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(C1.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(C1.class, "simple-bean-C1"));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(C2.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(C3.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(C4.class));
        assertThrows(DuplicitBeansException.class, () -> ApplicationContext.getInstance(C5.class));
    }
}