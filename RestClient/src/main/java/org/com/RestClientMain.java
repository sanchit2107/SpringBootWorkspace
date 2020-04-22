package org.com;

import org.springframework.web.client.RestTemplate;

public class RestClientMain {
	
	public static void main(String[] args) {
		
		RestTemplate restTemp = new RestTemplate();
		
		Product product1 = restTemp.getForObject("http://localhost:8085/product/searchProduct/106", Product.class);
		
		if(product1!=null)
			System.out.println("Found --- \n" + product1.getPrdId() + " " + product1.getPrdName() + " " + product1.getPrdCost());
	
		
		restTemp.getForObject("http://localhost:8085/product/searchProduct/105", Product.class);
		restTemp.delete("http://localhost:8085/product/deleteProduct/105");
		
		Product pUpdate = new Product(104, "SpringBoot Book", 4999);
		restTemp.put("http://localhost:8085/product/updateProduct", pUpdate);
	}
	
}
