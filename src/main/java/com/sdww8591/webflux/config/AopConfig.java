package com.sdww8591.webflux.config;

import com.sdww8591.webflux.entity.Demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Aspect
@Component
public class AopConfig {

    private static final Logger log = LoggerFactory.getLogger(AopConfig.class);

    //@Before("execution(* com.sdww8591.webflux.controller.HelloController.post(..))")
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void check(JoinPoint joinPoint) {
        log.info("start checking");

        ServerWebExchange serverWebExchange = null;

        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        for (Object arg: args) {
            if (Demo.class.isInstance(arg)) {
                if (!check(Demo.class.cast(arg))) {
                    log.info("check failed");
                }
            } else if (ServerWebExchange.class.isInstance(arg)) {
                serverWebExchange = (ServerWebExchange) arg;
            }
        }

        //获取方法名称
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info(methodSignature.getMethod().toString());

        //获取path等
        log.info(serverWebExchange.getRequest().getPath().toString());

    }

    private boolean check(Demo demo) {
        return true;
    }


}
