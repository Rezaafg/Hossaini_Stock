package Persistence;

import Model.CustomerAccount;
import Model.CustomerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

	private final static String SQL_Select_All =
			" Select Customer_ID,\n"+
					" Email,"+
					" Firstname,"+
					" Lastname,"+
					" Gender,"+
					" Birthdate,"+
					" Credits"+
					" From Customer";
	private PreparedStatement selectAllStatement;
	String dateFormat = "MM-ddy-yyy'T'HH:mm:ss";
	public List<CustomerAccount> selectAll(Connection con ) throws CustomerException {
		try {
		   
			if ( selectAllStatement == null ) {
				 selectAllStatement = con.prepareStatement(SQL_Select_All);
			} 
			 ResultSet rs = selectAllStatement.executeQuery();
			if ( rs != null )
			{	
				List<CustomerAccount> customer = new ArrayList<>();
				while( rs.next() )
				{		
					Long id= rs.getLong(1);
					String email = rs.getString(2);
					String firstname = rs.getString(3);
					String lastname = rs.getString(4);
					String gender = rs.getString(5);
					LocalDateTime birthdate = rs.getTimestamp(6).toLocalDateTime();
					Double credits = rs.getDouble(7);
					customer.add(new CustomerAccount(id, email,firstname, lastname, gender, birthdate,credits));
				}
				return customer;
			}
			else {
				throw new CustomerException( "Could not read data from database" );
			}			
		} catch ( SQLException e ) {
			throw new CustomerException( "Could not execute SQL statement" );
		}
	}

}