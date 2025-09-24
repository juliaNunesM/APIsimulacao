package com.trabalho.simulacao_credito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SimulacaoCreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulacaoCreditoApplication.class, args);
	}

}
