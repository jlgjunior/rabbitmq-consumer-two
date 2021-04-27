package com.course.rabbitmqtwo.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class InvoicePaidMessage {

	private String invoiceNumber;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate paidDate;
	private String paymentNumber;

	public InvoicePaidMessage() {

	}

	public InvoicePaidMessage(String invoiceNumber, LocalDate paidDate, String paymentNumber) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.paidDate = paidDate;
		this.paymentNumber = paymentNumber;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	@Override
	public String toString() {
		return "InvoicePaidMessage [invoiceNumber=" + invoiceNumber + ", paidDate=" + paidDate + ", paymentNumber="
				+ paymentNumber + "]";
	}
}