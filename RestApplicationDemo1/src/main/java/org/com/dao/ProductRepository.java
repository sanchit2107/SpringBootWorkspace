package org.com.dao;

import org.com.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(name = "avgCost", value= "select avg(p.prdCost) from Product p")
	public float getAverageCost();
	
	@Query(name = "minCost", value = "select min(p.prdCost) from Product p")
	public float getMinCostProduct();
}
