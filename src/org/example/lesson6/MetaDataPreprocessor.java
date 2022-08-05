package org.example.lesson6;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MetaDataPreprocessor {
    public static <T> void processMetaDataAnnotation(T prototype) throws IllegalAccessException, InvocationTargetException {
        Class<?> prototypeClass = prototype.getClass();
        Field[] declaredFields = prototypeClass.getDeclaredFields();
        int declaredFieldsLength = declaredFields.length;
        if (prototypeClass.isAnnotationPresent(GetMetaData.class)) {
            for (int i = 0; i < declaredFieldsLength; i++) {
                Field currentField = declaredFields[i];
                currentField.setAccessible(true);
                System.out.println(currentField.get(prototype));
            }
        }
        for (int i = 0; i < declaredFieldsLength; i++) {
            Field currentFiled = declaredFields[i];
            if (currentFiled.isAnnotationPresent(GetMetaData.class)) {
                currentFiled.setAccessible(true);
                System.out.println(currentFiled.get(prototype));
            }
        }
        Method[] declaredMethods = prototypeClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method currentMethod = declaredMethods[i];
            if (currentMethod.isAnnotationPresent(GetMetaData.class)) {
                long start = System.currentTimeMillis();
                currentMethod.invoke(prototype, null);
                long end = System.currentTimeMillis();
                System.out.println("Method was performed " + (end - start) + " seconds");
            }

        }

    }
}
