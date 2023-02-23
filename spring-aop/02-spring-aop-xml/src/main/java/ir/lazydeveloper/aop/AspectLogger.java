package ir.lazydeveloper.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectLogger {
    public void beforeLogger() {System.out.println("Before Logger");}
    public void afterLogger() {System.out.println("After Logger");}
    public void afterThrowingAdvice() {System.out.println("after throws exception Logger");}

    public void aroundAdvice(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around before advice");
        point.proceed();
        System.out.println("after before advice");
    }
}
