package com.mycompany.app.dao;


import com.mycompany.app.entity.OrderLine;

import java.util.List;

public interface OrderLineDAO {
	
	public List<OrderLine> getOrderLines();
	
	public void saveOrderLine(OrderLine theOrderLine);
	
	public List<OrderLine> getOrderLineByOrderHeaderID(int orderHeaderId);

	public void deleteOrderLine(int theId);
}
