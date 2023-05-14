package com.mycompany.app.controller;


import com.mycompany.app.dto.ProductDTO;
import com.mycompany.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	//ggggggggggggg
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String listProducts(@RequestParam(value = "productId", required = false) Integer theId, Model theModel) {
	 
	    List<ProductDTO> theProducts = productService.getProducts();
	 
	    theModel.addAttribute("products", theProducts);
	 
	    bindProductAttribute(theId, theModel);
	 
	    return "list-products"; 
	    
	    
	}

	private void bindProductAttribute(@RequestParam(value = "productId", required = false) Integer theId, Model theModel) {
	    ProductDTO theProduct = new ProductDTO();
	 
	    if (theId != null) {
	 
	        theProduct = productService.getProducts(theId);
	 
	        System.out.println("Product != null" + theProduct);
	    }
	 
	    theModel.addAttribute("product", theProduct);
	}
	
	

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") ProductDTO theProduct) {
		
		// save the product using our service
		productService.saveProduct(theProduct);	
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,
	                                RedirectAttributes redirectAttributes) {
	 
	    redirectAttributes.addAttribute("productId", theId);
	 
	    return "redirect:/products/list";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		// delete the product
		productService.deleteProduct(theId);
		
		return "redirect:/products/list";
	}

}
