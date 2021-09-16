package com.unsa.tourism.service;

import java.util.List;

import com.unsa.tourism.dto.ProductDTO;
import com.unsa.tourism.model.Product;

public interface ProductService {
	public List<Product> listStateActiveProduct(Integer state);
	public Product saveProduct(ProductDTO product);
	public Product updateProduct(Integer id ,ProductDTO productDTO);
	public void deleteProduct(Integer id);
}
