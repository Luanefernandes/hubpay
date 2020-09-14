package com.finnet.hubpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.finnet.hubpay.model.SolicitarPagamento;

@Service
public class RealizarTransacaoService {
	
	public class RestService {

	    private final RestTemplate restTemplate;

	    public RestService(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }

	    public String getPostsPlainJSON() {
	        String url = "https://ecommerce-hml.adiq.io";
	        return this.restTemplate.getForObject(url, String.class);
	    }
	}


}
