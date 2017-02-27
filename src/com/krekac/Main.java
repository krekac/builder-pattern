package com.krekac;

import java.util.ArrayList;
import java.util.Date;

import com.krekac.OrderWithBuilder.Builder;

public class Main {

	public static void main(String[] args) {
		//Client code examples		
		Order orderTelescopingConstructor = new Order(1,new Date());
		//Not clean initialization, using only 6 parameters, imagine more.
		orderTelescopingConstructor = new Order(1,new Date(),new Customer("Jozko Customer"), new ArrayList<Item>(), "Additional information","Note");
		//Need to fill also optional parameter even though  it is not needed, see the last parameter ""
		orderTelescopingConstructor = new Order(1,new Date(),new Customer("Jozko Customer"), new ArrayList<Item>(), "Additional information", "");
		//Easy to make mistakes, last two are swapped.
		orderTelescopingConstructor = new Order(1,new Date(),new Customer("Jozko Customer"), new ArrayList<Item>(), "Note", "Additional information");
		
		//Order with builder, cleaner solution
		OrderWithBuilder order = new OrderWithBuilder.Builder(1)
							     .customer(new Customer("Jozko Customer"))
							     .date(new Date())
							     .items(new ArrayList<Item>())
							     .build();
		
		order = new OrderWithBuilder.Builder(1).build();
		
		
		//Order with builder with static method
		OrderWithBuilderStatic orderStatic = OrderWithBuilderStatic.newBuilder(1)
                .build();

		//Order with builder that has a nested builder inside
		OrderWithNestedBuilder orderNested = new OrderWithNestedBuilder.Builder(1)
				                        .items(new ArrayList<Item>())
				                        .itemsInformation("Items info")
				                        
				                        .build();

//		OrderWithNestedBuilder order2 = new Order2.Builder(1)
//				                  .customer(new Customer("Jozko Customer"))
//				                  .itemsInformation("Add info")
//				                  .build();

		//Order with builder that deals with validation
		OrderWithValidationBuilder orderValid = new OrderWithValidationBuilder.Builder()
									.identificationNumber(1)
									.additionalInformation("Additional information")
									.build();

//		OrderWithValidationBuilder order3 = new Order3.Builder()
//									  .additionalInformation("Additional information")
//									  .build();
	}
}
