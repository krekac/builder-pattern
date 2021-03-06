package com.krekac;
import java.util.Date;
import java.util.List;


public class OrderWithBuilder {
	
	private Integer identificationNumber;
	private Date date;
	private Customer customer;
	private List<Item> items;
	private String additionalInfo;
	
	//private constructor
	private OrderWithBuilder(Builder builder){
		this.identificationNumber = builder.identificationNumber;
		this.date = builder.date;
		this.customer = builder.customer;
		this.items = builder.items;
		this.additionalInfo = builder.additionalInfo;
	}
		
	public static class Builder{
		private final Integer identificationNumber; //required
		
		private Date date; //optional
		private Customer customer; //optional
		private List<Item> items; //optional
		private String additionalInfo; //optional
		
	    Builder(Integer identificationNumber){
			this.identificationNumber = identificationNumber;
		}
		
		public Builder date(Date date){
			this.date = date;
			return this;
		}
		
		public Builder customer(Customer customer){
			this.customer = customer;
			return this;
		}
		
		public Builder additionalInfo(String additionalInfo){
			this.additionalInfo = additionalInfo;
			return this;
		}
		
		public Builder items(List<Item> items){
			this.items = items;
			return this;
		}
		
		public OrderWithBuilder build(){
			return new OrderWithBuilder(this);
		}
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

	public List<Item> getItems() {
		return items;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}
}
