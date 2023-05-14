package com.mycompany.app.service;


import com.mycompany.app.dto.ProductDTO;

import java.util.List;

public interface ProductService {
	
	public List<ProductDTO> getProducts();

	public void saveProduct(ProductDTO theProduct);

	public ProductDTO getProducts(int theId);

	public void deleteProduct(int theId);

}
