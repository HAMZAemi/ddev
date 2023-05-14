package com.mycompany.app.dao;



import com.mycompany.app.entity.OrderHeader;

import java.util.List;

public interface OrderHeaderDAO {

	List<OrderHeader> getOrderHeader();

	public OrderHeader getLastOrderHeader();

	public void saveOrderHeader(OrderHeader theOrderHeader);

	public OrderHeader getOrderHeaderByNumber(String orderHeaderId);
	
	public OrderHeader getOrderHeaderById(Integer orderHeaderId);

	public List<OrderHeader> getAllOrders();

	public List<OrderHeader> getAllOrders(String type);
}
