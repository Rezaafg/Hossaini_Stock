package Model;

import java.util.ArrayList;

public class Customers {

	ArrayList<Customer> customers;
	
	public Customers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	
}
