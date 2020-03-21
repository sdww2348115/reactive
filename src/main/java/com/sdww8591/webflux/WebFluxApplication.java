package com.sdww8591.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxApplication.class, args);
	}

}
