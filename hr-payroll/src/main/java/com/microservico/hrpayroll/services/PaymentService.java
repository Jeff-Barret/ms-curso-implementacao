package com.microservico.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservico.hrpayroll.entities.Payment;
import com.microservico.hrpayroll.entities.Worker;
import com.microservico.hrpayroll.feignclients.WorkerFeighClient;

//Esse projeto não vai ter banco de dados ele só tem regras de negocios e vai instanciar aqui os pagamentos com as regrinhas desenvolvidas aqui

@Service //Registra a classe como Serviço do Spring
public class PaymentService {
	
	/*@Value("${hr-worker.host}")
	private String workerHost;*/
	
	@Autowired
	private WorkerFeighClient workerFeignClient;
	//private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) { //Metodo para intaciar um pagamento
		
		/*Map<String, String> uriVariables = new HashMap<>();//Mapa/Dicionario de parametros
		uriVariables.put("id", ""+workerId);*/
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
