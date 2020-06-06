package Model;


import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;


public class Customers {

	ArrayList<CustomerAccount> customers;
	
	public Customers() {
	customers = new ArrayList<>();
	}
	public ArrayList<CustomerAccount> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<CustomerAccount> customers) {
		this.customers = customers;
	}
	public void clear() {
		customers.clear();
	}

	public void remove(CustomerAccount a) {
		customers.remove(a);
	}

	public void remove(CustomerAccount... cut) {
		for (CustomerAccount a: cut) {
			remove(a);
		}
	}

	
	public void addAll( List<CustomerAccount> customerList ) {
		customers.addAll( customerList );
	}
	
	public List<CustomerAccount> getAccounts(){
		return Collections.unmodifiableList( customers );
	}
	
	@Override
	public String toString() {
		return "Customer [customer=" + customers + "]";
	}

	
}
