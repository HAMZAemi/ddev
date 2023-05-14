package com.mycompany.app.controller;


import com.mycompany.app.dto.CustomerDTO;
import com.mycompany.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/CRM")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(@RequestParam(value = "customerId", required = false) Integer theId, Model theModel) {
	 
	    List<CustomerDTO> theCustomers = customerService.getCustomer();
	 
	    theModel.addAttribute("customers", theCustomers);
	 
	    bindCustomerAttribute(theId, theModel);
	 
	    return "list-customers";
	}

	private void bindCustomerAttribute(@RequestParam(value = "customerId", required = false) Integer theId, Model theModel) {
	    CustomerDTO theCustomer = new CustomerDTO();
	 
	    if (theId != null) {
	 
	        theCustomer = customerService.getCustomer(theId);
	 
	        System.out.println("Customer != null" + theCustomer);
	    }
	 
	    theModel.addAttribute("customer", theCustomer);
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		CustomerDTO theCustomer = new CustomerDTO();

		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") CustomerDTO theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);	
		
		return "redirect:/CRM/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
	                                RedirectAttributes redirectAttributes) {
	 
	    redirectAttributes.addAttribute("customerId", theId);
	 
	    return "redirect:/CRM/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/CRM/list";
	}
	

	
}

