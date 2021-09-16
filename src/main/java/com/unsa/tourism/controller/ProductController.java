package com.unsa.tourism.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unsa.tourism.constants.TourismConstants;
import com.unsa.tourism.dto.CreateEntityResponseDTO;
import com.unsa.tourism.dto.ProductDTO;
import com.unsa.tourism.model.Product;
import com.unsa.tourism.service.ProductService;
import com.unsa.tourism.util.TourismUtil;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(TourismConstants.API_VERSION + TourismConstants.RESOURCE_PRODUCTS)
public class ProductController {
	
	@Autowired
	ProductService productService;
	
    @GetMapping
    public List<Product> getProducts() {
        return productService.listStateActiveProduct(1);
    }
    
    @PostMapping(TourismConstants.RESOURCE_PRODUCTS_RESOURCE_PRODUCT)
    public ResponseEntity<CreateEntityResponseDTO> postProducts(@RequestBody ProductDTO productDTO) {
       Product product= productService.saveProduct(productDTO);       
       return new ResponseEntity<>(
                TourismUtil.createEntityFromResource(product.getId(), TourismConstants.API_VERSION
                        + TourismConstants.RESOURCE_PRODUCTS + 
                        TourismConstants.RESOURCE_PRODUCTS_RESOURCE_PRODUCT),
                HttpStatus.CREATED);
    }
    
    @PutMapping(TourismConstants.RESOURCE_PRODUCTS_RESOURCE_PRODUCT )
    public ResponseEntity<CreateEntityResponseDTO> updateProduct(@Parameter Integer id,
    												@Valid @RequestBody ProductDTO productDTO){
    	
    	 Product product= productService.updateProduct(id,productDTO);       
         return new ResponseEntity<>(
                  TourismUtil.createEntityFromResource(product.getId(), TourismConstants.API_VERSION
                          + TourismConstants.RESOURCE_PRODUCTS + 
                          TourismConstants.RESOURCE_PRODUCTS_RESOURCE_PRODUCT),
                  HttpStatus.CREATED);
    }

   @DeleteMapping(TourismConstants.RESOURCE_PRODUCTS_RESOURCE_PRODUCT)
    ResponseEntity<Void> deleteFile(@Parameter Integer id) {
	   productService.deleteProduct(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
