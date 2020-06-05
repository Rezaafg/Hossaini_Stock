package Model;

public class Customer {

	private int customerID;
	private String firstName;
	private double credit;
	public Customer(int customerID, String firstName, double credit) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.credit= credit;
	} 
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
}
