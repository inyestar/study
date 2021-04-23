package com.inminhouse.study.spring.ch05.property;

public class Money {

	private int amount;
	private String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String toString() {
		return new StringBuilder()
				.append("amount=").append(amount)
				.append(",")
				.append("currency=").append(currency)
				.toString();
	}
}
