package com.plavajs.libs.simpleinject;

import com.plavajs.libs.simpleinject.annotation.*;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ClassScanner01Test {


    @SuppressWarnings("unchecked")
    @Test
    void allClassesLoaded() throws IllegalAccessException {
        Field allClassesField = FieldUtils.getDeclaredField(ClassScanner.class, "allClasses", true);
        allClassesField.setAccessible(true);
        Set<Class<?>> allClasses = (Set<Class<?>>) allClassesField.get(null);
        assertNotNull(allClasses);
        assertNotEquals(0, allClasses.size());
    }

    @Test
    void findClassesAnnotatedWith() {
        Set<Class<?>> componentClasses = ClassScanner.findClassesAnnotatedWith(SimpleComponent.class);
        Set<Class<?>> configClasses = ClassScanner.findClassesAnnotatedWith(SimpleConfiguration.class);
        Set<Class<?>> componentScansClasses = ClassScanner.findClassesAnnotatedWith(SimpleComponentScans.class);
        Set<Class<?>> componentScanClasses = ClassScanner.findClassesAnnotatedWith(SimpleComponentScan.class);
        Set<Class<?>> eagerInstancesClasses = ClassScanner.findClassesAnnotatedWith(SimpleEagerInstances.class);
        assertEquals(17, componentClasses.size());
        assertEquals(1, configClasses.size());
        assertEquals(1, componentScansClasses.size());
        assertEquals(0, componentScanClasses.size());
        assertEquals(2, eagerInstancesClasses.size());
    }

    @Test
    void findClassesInPackage() {
        Set<Class<?>> DClasses = ClassScanner.findClassesInPackage("d", false);
        Set<Class<?>> DEClasses = ClassScanner.findClassesInPackage("d", true);
        assertEquals(2, DClasses.size());
        assertEquals(4, DEClasses.size());
    }

    @Test
    void getRootPackages() {
        Set<String> rootPackages = ClassScanner.getRootPackages();
        assertEquals(2, rootPackages.size());
        assertTrue(rootPackages.contains("com"));
        assertTrue(rootPackages.contains("d"));
    }
}
