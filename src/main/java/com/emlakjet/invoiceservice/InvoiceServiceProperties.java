package com.emlakjet.invoiceservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="invoice")
public class InvoiceServiceProperties {
	private Long creditLimit;

	public Long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Long creditLimit) {
		this.creditLimit = creditLimit;
	}
}
