package ir.lazydeveloper.aop;

import java.util.List;

public class ProxyFactoryBean {
    private Object target;
    private List interceptorNames;

    public Object getTarget() {
        return target;
    }

    public ProxyFactoryBean setTarget(Object target) {
        this.target = target;
        return this;
    }

    public List getInterceptorNames() {
        return interceptorNames;
    }

    public ProxyFactoryBean setInterceptorNames(List interceptorNames) {
        this.interceptorNames = interceptorNames;
        return this;
    }
}
