package ir.lazydeveloper.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ir.lazydeveloper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
