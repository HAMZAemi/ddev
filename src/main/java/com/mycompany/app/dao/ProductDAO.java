package com.mycompany.app.dao;


import com.mycompany.app.entity.Product;

import java.util.List;

public interface ProductDAO {
	
	 List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);
	
	public Product getProduct(String name);

}
