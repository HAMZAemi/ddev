package com.mycompany.app.service;


import com.mycompany.app.dto.OrderLineDTO;

import java.util.List;

public interface OrderLineService {

	public List<OrderLineDTO> getOrderLines();

	public void saveOrderLine(OrderLineDTO theOrderLine);

	List<OrderLineDTO> getOrderLinesbyOrderHeaderID(int orderHeaderID);
	
	public void deleteOrderLine(int theId);
	
	
}
