package com.unsa.tourism.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsa.tourism.constants.TourismConstants;
import com.unsa.tourism.dto.ProductDTO;
import com.unsa.tourism.model.Product;
import com.unsa.tourism.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository; 
	@Override
	public List<Product> listStateActiveProduct(Integer state) {
		return productRepository.findProductByState(state);
	}

	@Override
	public Product saveProduct(ProductDTO product) {
		Product newProduct =new Product();
		newProduct.setName(product.getName());
		newProduct.setDescription(product.getDescription());
		newProduct.setCode(product.getCode());
		newProduct.setState(1);
		newProduct.setRegistrationDate(new Date());
		return productRepository.save(newProduct);
	}

	@Override
	public Product updateProduct(Integer id, ProductDTO productDTO) {
		Product product =productRepository.findByIdAndState(id,TourismConstants.RESORCE_ENABLE).orElseThrow(RuntimeException::new);
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setCode(productDTO.getCode());
		product.setState(1);
		product.setRegistrationDate(new Date());
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		Product product =productRepository.findByIdAndState(id,TourismConstants.RESORCE_ENABLE).orElseThrow(RuntimeException::new);
		product.setState(TourismConstants.RESORCE_DISABLE);
		productRepository.save(product);
	}

	
 }
