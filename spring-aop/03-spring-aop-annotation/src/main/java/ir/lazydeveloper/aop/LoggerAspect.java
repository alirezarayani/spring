package ir.lazydeveloper.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    //    @Pointcut("@annotation(ir.lazydeveloper.common.MyAnnotation)")
//    @Pointcut("execution(public * ir.lazydeveloper.contorller.PersonController.*(..) throws Exception)")
//    @Pointcut("within(ir.lazydeveloper.repository.*)")
//    @Pointcut("@args(ir.lazydeveloper.common.MyAnnotation)")
//    @Pointcut("@target(ir.lazydeveloper.common.MyAnnotation)")
    @Pointcut("@within(org.springframework.stereotype.Repository))")
    public void loggableMethods() {
    }

    @Before("loggableMethods()")
    public void logBeforeController() {
        System.out.println("Log before call method from aspect");
    }
}
