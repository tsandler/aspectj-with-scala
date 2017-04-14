package aspects;


import annotations.Annotation;

//public aspect AnnotationAspect {
//
//    pointcut hasAnnotation(Annotation encryptedWithAnnotation) : @annotation(encryptedWithAnnotation);
//
//    Object around(Annotation encryptedWithAnnotation, String pass) : hasAnnotation(encryptedWithAnnotation) && set(String *) && args(pass) {
//        Object result = null;
//        System.out.println(thisJoinPoint);
//        try {
//            result = proceed(encryptedWithAnnotation, "intercepted");
//        } catch (RuntimeException ex) {
//            throw ex;
//        }
//        return result;
//    }
//}
