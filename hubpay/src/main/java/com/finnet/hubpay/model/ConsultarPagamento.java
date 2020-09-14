package com.finnet.hubpay.model;

import java.util.Date;

public class ConsultarPagamento {
	
	private String PaymentAuthorizationPaymentId;
	
	private String PaymentAuthorizationStatusDescription;
	
	private Date PaymentAuthorizationTransactionDate;
	
	public String getPaymentAuthorizationPaymentId() {
		return PaymentAuthorizationPaymentId;
	}
	public void setPaymentAuthorizationPaymentId(String paymentAuthorizationPaymentId) {
		PaymentAuthorizationPaymentId = paymentAuthorizationPaymentId;
	}
	public String getPaymentAuthorizationStatusDescription() {
		return PaymentAuthorizationStatusDescription;
	}
	public void setPaymentAuthorizationStatusDescription(String paymentAuthorizationStatusDescription) {
		PaymentAuthorizationStatusDescription = paymentAuthorizationStatusDescription;
	}
	public Date getPaymentAuthorizationTransactionDate() {
		return PaymentAuthorizationTransactionDate;
	}
	public void setPaymentAuthorizationTransactionDate(Date paymentAuthorizationTransactionDate) {
		PaymentAuthorizationTransactionDate = paymentAuthorizationTransactionDate;
	}
	
	

}
