package com.plavajs.libs.simpleinject;

import com.plavajs.libs.simpleinject.a.*;
import com.plavajs.libs.simpleinject.b.*;
import com.plavajs.libs.simpleinject.c.*;
import com.plavajs.libs.simpleinject.exception.MissingBeanException;
import d.D2;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContext01Test {

    private static Set<MethodBean> SIMPLE_BEANS;
    private static Set<ComponentBean> COMPONENT_BEANS;

    @SuppressWarnings("unchecked")
    @BeforeAll
    static void setup() throws IllegalAccessException {
        Field simpleBeansField = FieldUtils.getDeclaredField(ApplicationContext.class, "methodBeans", true);
        simpleBeansField.setAccessible(true);
        SIMPLE_BEANS = (Set<MethodBean>) simpleBeansField.get(null);
        Field componentBeansField = FieldUtils.getDeclaredField(ApplicationContext.class, "componentBeans", true);
        componentBeansField.setAccessible(true);
        COMPONENT_BEANS = (Set<ComponentBean>) componentBeansField.get(null);
    }

    @Test
    void beansLoaded() {
        assertNotNull(SIMPLE_BEANS);
        assertEquals(3, SIMPLE_BEANS.size());
        assertNotNull(COMPONENT_BEANS);
        assertEquals(16, COMPONENT_BEANS.size());
    }

    private void eagerInstances() {
        SIMPLE_BEANS.forEach(bean -> assertNotNull(bean.getInstance()));
        COMPONENT_BEANS.forEach(bean -> assertNotNull(bean.getInstance()));
    }

    @Test
    void a_components_notThrows_allDependenciesNotNull() {
        eagerInstances();

        A1[] a1 = new A1[1];
        assertDoesNotThrow(() -> a1[0] = ApplicationContext.getInstance(A1.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(A2.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(A3.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(A4.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(A5.class));
        assertNotNull(a1[0]);
        assertNotNull(a1[0].getA2());
        assertNotNull(a1[0].getA2().getA3());
        assertNotNull(a1[0].getA2().getA3().getA4());
        assertNotNull(a1[0].getA2().getA3().getA5());
        assertNotNull(a1[0].getA2().getA4());
        assertNotNull(a1[0].getA2().getA4().getA5());
    }

    @Test
    void a_simpleBean_notThrows_allDependenciesNotNull() {
        eagerInstances();

        A1[] a1 = new A1[1];
        assertDoesNotThrow(() -> a1[0] = ApplicationContext.getInstance(A1.class, "simple-bean-A1"));
        assertNotNull(a1[0]);
        assertNotNull(a1[0].getA2());
        assertNotNull(a1[0].getA2().getA3());
        assertNotNull(a1[0].getA2().getA3().getA4());
        assertNotNull(a1[0].getA2().getA3().getA5());
        assertNotNull(a1[0].getA2().getA4());
        assertNotNull(a1[0].getA2().getA4().getA5());
    }

    @Test
    void b_injects_notThrows_allDependenciesNotNull() {
        eagerInstances();

        B1[] b1 = new B1[1];
        assertDoesNotThrow(() -> b1[0] = ApplicationContext.getInstance(B1.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(B2.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(B3.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(B4.class));
        assertDoesNotThrow(() -> ApplicationContext.getInstance(B5.class));
        assertNotNull(b1[0]);
        assertNotNull(b1[0].getB2());
        assertNotNull(b1[0].getB2().getB3());
        assertNotNull(b1[0].getB2().getB3().getB4());
        assertNotNull(b1[0].getB2().getB3().getB5());
        assertNotNull(b1[0].getB2().getB4());
        assertNotNull(b1[0].getB2().getB4().getB5());
    }

    @Test
    void b_simpleBean_notThrows_allDependenciesNotNull() {
        eagerInstances();

        B1[] b1 = new B1[1];
        assertDoesNotThrow(() -> b1[0] = ApplicationContext.getInstance(B1.class, "simple-bean-B1"));
        assertNotNull(b1[0]);
        assertNotNull(b1[0].getB2());
        assertNotNull(b1[0].getB2().getB3());
        assertNotNull(b1[0].getB2().getB3().getB4());
        assertNotNull(b1[0].getB2().getB3().getB5());
        assertNotNull(b1[0].getB2().getB4());
        assertNotNull(b1[0].getB2().getB4().getB5());
    }

    @Test
    void c_componentsInjects_notThrows_allDependenciesNotNull() {
        eagerInstances();

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
        eagerInstances();

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
    void d_notExistingBean_throws() {
        assertThrows(MissingBeanException.class, () -> ApplicationContext.getInstance(A1.class, "not-existing-identifier"));
        assertThrows(MissingBeanException.class, () -> ApplicationContext.getInstance(D2.class));
    }
}