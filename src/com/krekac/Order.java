package com.krekac;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private static final String DEFAULT_NOTE = "No Note";
	private static final String DEFAULT_INFO = "No Info";
	private static final String DEFAULT_CUSTOMER = "Default Customer";
	
	private final Integer identificationNumber; // required
	private final Date date; // required
	private Customer customer; //optional
	private List<Item> items; //optional
	private String additionalInformation; //optional
	private String note; //optional

	// Telescoping constructor pattern
	public Order(Integer identificationNumber, Date date) {
		this(identificationNumber, new Date(), new Customer(DEFAULT_CUSTOMER));
	}

	public Order(Integer identificationNumber, Date date, Customer customer) {
		this(identificationNumber, new Date(), new Customer(DEFAULT_CUSTOMER), new ArrayList<Item>());
	}
	
	public Order(Integer identificationNumber, Date date, Customer customer, List<Item> items) {
		this(identificationNumber, new Date(), new Customer(DEFAULT_CUSTOMER), new ArrayList<Item>(), DEFAULT_INFO);
	}
	
	public Order(Integer identificationNumber, Date date, Customer customer, List<Item> items, String additionalInformation) {
		this(identificationNumber, new Date(), new Customer(DEFAULT_CUSTOMER), new ArrayList<Item>(), additionalInformation, DEFAULT_NOTE);
	}

	public Order(Integer identificationNumber, Date date, Customer customer, List<Item> items, String additionalInformation, String note) {
		this.identificationNumber = identificationNumber;
		this.date = date;
		this.customer = customer;
		this.items = items;
		this.additionalInformation = additionalInformation;
		this.note = note;
	}

	public Integer getIdentificationNumber() {
		return identificationNumber;
	}

	public Date getDate() {
		return date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}