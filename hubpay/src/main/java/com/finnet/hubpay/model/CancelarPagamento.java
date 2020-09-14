package com.finnet.hubpay.model;

public class CancelarPagamento {
	
	private long PaymentId;
	
	private float Amount;
	
	private String SellersId;
	
	
	public long getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(long paymentId) {
		PaymentId = paymentId;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getSellersId() {
		return SellersId;
	}
	public void setSellersId(String sellersId) {
		SellersId = sellersId;
	}
	
	
	

}
