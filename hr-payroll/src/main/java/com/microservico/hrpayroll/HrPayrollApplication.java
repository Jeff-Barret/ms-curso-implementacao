package com.microservico.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient (name = "hr-worker")
@EnableFeignClients //Feramenta utilizada para conversar entre projetos e o Feign já é integrado com outras ferramentas do cloud spring
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
