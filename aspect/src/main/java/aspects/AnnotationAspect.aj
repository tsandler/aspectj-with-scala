package aspects;

import annotations.Annotation;
import java.lang.reflect.Field;

public aspect AnnotationAspect {

    pointcut hasAnnotation(Annotation encryptedWithAnnotation) : @annotation(encryptedWithAnnotation);

    Object around(Annotation encryptedWithAnnotation, String pass) : hasAnnotation(encryptedWithAnnotation) && set(String *) && args(pass) {
        Object result = null;
        System.out.println(thisJoinPoint);
        try {
            result = proceed(encryptedWithAnnotation, "intercepted");
        } catch (RuntimeException ex) {
            throw ex;
        }
        return result;
    }

    Object around(Field field, Object value) :
        within(com.google.gson..*) &&
        call(public void Field.set(Object, Object)) &&
        target(field) &&
        args(*, value)
    {
        Object result = null;
        System.out.println(thisJoinPoint);
        try {
            if (field.getAnnotation(Annotation.class) != null && field.getType() == String.class)
                result = proceed(field, "intercepted");
            else
                result = proceed(field, value);
        } catch (RuntimeException ex) {
            throw ex;
        }
        return result;
    }

}
