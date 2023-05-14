package com.mycompany.app.service;



import com.mycompany.app.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

		
		public List<CustomerDTO> getCustomer();
		
		public void saveCustomer(CustomerDTO theCustomer);

		public CustomerDTO getCustomer(int theId);

		public void deleteCustomer(int theId);
		
	}
