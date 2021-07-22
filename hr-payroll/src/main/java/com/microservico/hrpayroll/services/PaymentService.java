package com.microservico.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.microservico.hrpayroll.entities.Payment;

//Esse projeto não vai ter banco de dados ele só tem regras de negocios e vai instanciar aqui os pagamentos com as regrinhas desenvolvidas aqui

@Service //Registra a classe como Serviço do Spring
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) { //Metodo para intaciar um pagamento
		return new Payment("Bob", 200.0, days);
	}
}
