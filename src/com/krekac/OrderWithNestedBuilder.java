package com.krekac;
import java.util.Date;
import java.util.List;

public class OrderWithNestedBuilder {

	private Integer identificationNumber;
	private Date date;
	private Customer customer;
	private List<Item> items;
	private String itemsInformation;

	private OrderWithNestedBuilder(Builder builder) {
		this.identificationNumber = builder.identificationNumber;
		this.date = builder.date;
		this.customer = builder.customer;
		this.items = builder.items;
		this.itemsInformation = builder.itemsInformation;
	}

	public static class Builder {
		private final Integer identificationNumber;

		private Date date;
		private Customer customer;
		private List<Item> items;
		private String itemsInformation;

		Builder(Integer identificationNumber) {
			this.identificationNumber = identificationNumber;
		}

		public Builder date(Date date) {
			this.date = date;
			return this;
		}

		public Builder customer(Customer customer) {
			this.customer = customer;
			return this;
		}

		public AdditionalItemInfoBuilder items(List<Item> items) {
			this.items = items;
			return new AdditionalItemInfoBuilder(this);
		}

		public OrderWithNestedBuilder build() {
			return new OrderWithNestedBuilder(this);
		}

		public class AdditionalItemInfoBuilder {

			private Builder builder;
			AdditionalItemInfoBuilder(Builder builder) {
				builder = this.builder;
			}

			public Builder itemsInformation(String itemsInformation) {
				builder.itemsInformation = itemsInformation;
				return builder;
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

	public String getItemsInformation() {
		return itemsInformation;
	}
}
