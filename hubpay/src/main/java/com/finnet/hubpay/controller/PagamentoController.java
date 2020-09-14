package com.finnet.hubpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.finnet.hubpay.model.SolicitarPagamento;
import com.finnet.hubpay.model.ConsultarPagamento;
import com.finnet.hubpay.model.CancelarPagamento;


@RequestMapping("/paymentAdiq")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PagamentoController {
	
		@Autowired
		private RestTemplate restTemplate;	
		
		private static String url = "https://ecommerce-hml.adiq.io"; //Endereço informado da documentação da API Adiq para o tipo Get
		
		private HttpHeaders createHttpHeaders(String user, String password)
		{
		    String notEncoded = user + ":" + password;
		    String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.add("Authorization", "Basic ZGV2ZWxvcGVycy5hZGlxLmlv");
		    return headers;
		}
		
		@GetMapping
		private void ConsultarPagamento() 
		{
		    String theUrl = url + "/v1/payments/1";
		    RestTemplate restTemplate = new RestTemplate();
		    try {
		        HttpHeaders headers = createHttpHeaders("Luane","1234");
		        HttpEntity<String> entity = new HttpEntity<String>(headers);
		        ResponseEntity<ConsultarPagamento> response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, ConsultarPagamento.class);
		        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
		    }
		    catch (Exception eek) {
		        System.out.println("** Exception: "+ eek.getMessage());
		    }
		}
		
		@PostMapping
		private void RealizarPagamento() 
		{
		    String theUrl = url + "/v1/validate";
		    RestTemplate restTemplate = new RestTemplate();
		    try {
		        HttpHeaders headers = createHttpHeaders("Luane","1234");
		        HttpEntity<String> entity = new HttpEntity<String>(headers);
		        ResponseEntity<SolicitarPagamento> response = restTemplate.exchange(theUrl, HttpMethod.POST, entity, SolicitarPagamento.class);
		        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
		    }
		    catch (Exception eek) {
		        System.out.println("** Exception: "+ eek.getMessage());
		    }
		}
		
		@PutMapping
		private void CancelarPagamento() 
		{
		    String theUrl = url + "/v1/payments/1/cancel";
		    RestTemplate restTemplate = new RestTemplate();
		    try {
		        HttpHeaders headers = createHttpHeaders("Luane","1234");
		        HttpEntity<String> entity = new HttpEntity<String>(headers);
		        ResponseEntity<CancelarPagamento> response = restTemplate.exchange(theUrl, HttpMethod.PUT, entity, CancelarPagamento.class);
		        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
		    }
		    catch (Exception eek) {
		        System.out.println("** Exception: "+ eek.getMessage());
		    }
		}
		
}

