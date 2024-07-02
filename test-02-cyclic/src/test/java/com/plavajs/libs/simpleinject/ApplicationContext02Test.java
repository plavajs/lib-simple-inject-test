package com.plavajs.libs.simpleinject;

import com.plavajs.libs.simpleinject.a.*;
import com.plavajs.libs.simpleinject.b.*;
import com.plavajs.libs.simpleinject.c.*;
import com.plavajs.libs.simpleinject.d.*;
import com.plavajs.libs.simpleinject.e.E1;
import com.plavajs.libs.simpleinject.exception.CyclicDependencyException;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContext02Test {

    private static Set<MethodBean> SIMPLE_BEANS;
    private static Set<ComponentBean> COMPONENT_BEANS;

    @SuppressWarnings("unchecked")
    @BeforeAll
    static void setup() throws IllegalAccessException {
        ApplicationContext.getInstance(E1.class);
        Field simpleBeansField = FieldUtils.getDeclaredField(ApplicationContext.class, "methodBeans", true);
        simpleBeansField.setAccessible(true);
        SIMPLE_BEANS = (Set<MethodBean>) simpleBeansField.get(null);
        Field componentBeansField = FieldUtils.getDeclaredField(ApplicationContext.class, "componentBeans", true);
        componentBeansField.setAccessible(true);
        COMPONENT_BEANS = (Set<ComponentBean>) componentBeansField.get(null);

        notEagerInstances();
    }

    private static void notEagerInstances() {
        SIMPLE_BEANS.stream()
                .filter(bean -> !bean.getType().equals(E1.class))
                .forEach(bean -> assertNull(bean.getInstance()));
        COMPONENT_BEANS.stream()
                .filter(bean -> !bean.getType().equals(E1.class))
                .forEach(bean -> assertNull(bean.getInstance()));
    }
    
    @Test
    void a_components_throws() {
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(A1.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(A1.class, "simple-bean-A1"));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(A2.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(A3.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(A4.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(A5.class));
    }

    @Test
    void b_injects_throws() {
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(B1.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(B1.class, "simple-bean-B1"));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(B2.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(B3.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(B4.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(B5.class));
    }

    @Test
    void c_componentsInjects_notThrows_allDependenciesNotNull() {
        C1[] c1 = new C1[1];
        assertDoesNotThrow(() -> c1[0] = ApplicationContext.getInstance(C1.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(C2.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(C3.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(C4.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(C5.class));
        assertNotNull(c1[0]);
        assertNotNull(c1[0].getC2());
        assertNotNull(c1[0].getC2().getC3());
        assertNotNull(c1[0].getC2().getC3().getC4());
        assertNotNull(c1[0].getC2().getC3().getC5());
        assertNotNull(c1[0].getC2().getC4());
        assertNotNull(c1[0].getC2().getC4().getC5());
    }

    @Test
    void c_simpleBean_notThrows_allDependenciesNotNull() {
        C1[] c1 = new C1[1];
        assertDoesNotThrow(() -> c1[0] = ApplicationContext.getInstance(C1.class, "simple-bean-C1"));
        assertNotNull(c1[0]);
        assertNotNull(c1[0].getC2());
        assertNotNull(c1[0].getC2().getC3());
        assertNotNull(c1[0].getC2().getC3().getC4());
        assertNotNull(c1[0].getC2().getC3().getC5());
        assertNotNull(c1[0].getC2().getC4());
        assertNotNull(c1[0].getC2().getC4().getC5());
    }

    @Test
    void d_componentsInjects_throws() {
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(D1.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(D1.class, "simple-bean-D1"));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(D2.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(D3.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(D4.class));
        assertThrows(CyclicDependencyException.class, () -> ApplicationContext.getInstance(D5.class));
    }
}