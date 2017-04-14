package aspects;


import annotations.Annotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnnotationAspect {

    @Pointcut("@annotation(annotationVariableNames)")
    public void hasAnnotation(Annotation annotationVariableNames){
    }

    @Around("hasAnnotation(annotationVariableNames) && set(String *) && args(pass)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, Annotation annotationVariableNames, String pass) throws Throwable{
        Object returnObject = null;
        try {
            joinPoint.proceed(new Object[] {"intercepted"});
        } catch (Throwable throwable) {
            throw throwable;
        }
        return returnObject;
    }
}