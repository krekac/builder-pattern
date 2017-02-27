package com.krekac;
import java.util.Date;
import java.util.List;

public class OrderWithValidationBuilder {

	private Integer identificationNumber;
	private Date date;
	private Customer customer;
	private List<Item> items;
	private String additionalInformation;

	private OrderWithValidationBuilder(Builder builder) {
		this.identificationNumber = builder.identificationNumber;
		this.date = builder.date;
		this.customer = builder.customer;
		this.items = builder.items;
		this.additionalInformation = builder.additionalInformation;
	}

	public static class Builder {
		private Integer identificationNumber;
		private Date date;
		private Customer customer;
		private List<Item> items;
		private String additionalInformation;

		public ValidBuilder identificationNumber(Integer identificationNumber) {
			this.identificationNumber = identificationNumber;
			return new ValidBuilder(this);
		}
		
		public InvalidBuilder date(Date date){
			this.date = date;
			return new InvalidBuilder(this);
		}
		
		public InvalidBuilder customer(Customer customer){
			this.customer = customer;
			return new InvalidBuilder(this);
		}
		
		public InvalidBuilder additionalInformation(String additionalInformation){
			this.additionalInformation = additionalInformation;
			return new InvalidBuilder(this);
		}
		
		public InvalidBuilder items(List<Item> items){
			this.items = items;
			return new InvalidBuilder(this);
		}
		
		public class ValidBuilder{
			private Builder builder;
			
			public ValidBuilder(Builder builder) {
				this.builder = builder;
			}

			public ValidBuilder date(Date date){
				this.builder.date = date;
				return this;
			}
			
			public ValidBuilder customer(Customer customer){
				this.builder.customer = customer;
				return this;
			}
			
			public ValidBuilder additionalInformation(String additionalInfo){
				this.builder.additionalInformation = additionalInformation;
				return this;
			}
			
			public ValidBuilder items(List<Item> items){
				this.builder.items = items;
				return this;
			}
			
			public OrderWithValidationBuilder build(){
				return new OrderWithValidationBuilder(builder);
			}
		}
		
		public class InvalidBuilder{
			private Builder builder;
			
			public InvalidBuilder(Builder builder) {
				this.builder = builder;
			}

			public InvalidBuilder date(Date date){
				this.builder.date = date;
				return this;
			}
			
			public InvalidBuilder customer(Customer customer){
				this.builder.customer = customer;
				return this;
			}
			
			public InvalidBuilder additionalInformation(String additionalInformation){
				this.builder.additionalInformation = additionalInformation;
				return this;
			}
			
			public InvalidBuilder items(List<Item> items){
				this.builder.items = items;
				return this;
			}
			
			public ValidBuilder identificationNumber(Integer identificationNumber) {
				this.builder.identificationNumber = identificationNumber;
				return new ValidBuilder(builder);
			}
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

	public String getAdditionalInformation() {
		return additionalInformation;
	}
}
