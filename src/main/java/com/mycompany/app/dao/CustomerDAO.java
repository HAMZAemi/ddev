package com.mycompany.app.dao;


import com.mycompany.app.entity.Customer;

import java.util.List;

public interface CustomerDAO  {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
	public Customer getCustomer(String email);

	public void deleteCustomer(int theId);

}
