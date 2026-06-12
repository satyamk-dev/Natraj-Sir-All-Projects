package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.document.Product;
import com.nt.repository.IProductRepository;

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService {
	@Autowired
    private  IProductRepository  prodRepo;

	@Override
	public String saveProduct(Product prod) {
		//save the document
		String idVal=prodRepo.save(prod).getId();
		return  " Product is saved  with  id Value ::"+idVal;
	}

	@Override
	public String saveProducts(List<Product> prods) {
		 //save the docs
		List<Product> savedProds=prodRepo.saveAll(prods);
		//gather only  id values
		List<String> ids=savedProds.stream().map(Product::getId).toList();
		return ids.size()+"  documents are saved with  id values ::"+ids;
	}

	@Override
	public List<Product> showAllProducts() {
		return prodRepo.findAll();
	}
	
	@Override
	public Product showProductId(String id) {
		 //Load the object
		Product prod=prodRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		return prod;
	}
	
	@Override
	public String updateProductPrice(String id, double hikePercent) {
		//Load the object
		Product prod=prodRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		//update the object
		prod.setPrice(prod.getPrice()+ (prod.getPrice()*hikePercent/100.0));
		  prodRepo.save(prod);
		 return  "Product  price is  hiked to "+prod.getPrice();
	}
	
	@Override
	public String removeProductsByNameAndCatetory(String name, String company) {
		  // Create Product object having inputs
		  Product prod=new Product(); prod.setName(name); prod.setCompany(company);
		  //Example object
		  Example<Product>  example=Example.of(prod);
		  //invoke the method
		  List<Product>  list=prodRepo.findAll(example);
		  //remove  the  docs
		  prodRepo.deleteAll(list);
		  
		return list.size()+" no.of docs are deleted";
	}

}
