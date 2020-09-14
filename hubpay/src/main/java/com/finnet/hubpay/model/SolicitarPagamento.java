package com.finnet.hubpay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_pagar")
public class SolicitarPagamento {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long paymentId;
	
	@NotNull
	private String transactionType;
	
	@NotNull
	private float amount;
	
	@NotNull
	private String paymentCurrencyCode;
	

	public SolicitarPagamento(int i, String string, double d, String string2) {
		
	}

	public String getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}


	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public String getPaymentCurrencyCode() {
		return paymentCurrencyCode;
	}
	
	public void setPaymentCurrencyCode(String paymentCurrencyCode) {
		paymentCurrencyCode = paymentCurrencyCode;
	}

	
	
	

}
