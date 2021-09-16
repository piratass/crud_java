package com.unsa.tourism.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.unsa.tourism.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	 public List<Product> findProductByState (Integer state);
	 public Optional<Product> findByIdAndState(Integer id, Integer state);
}
