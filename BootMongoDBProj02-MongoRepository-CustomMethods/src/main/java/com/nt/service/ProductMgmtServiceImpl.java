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
	public List<Product> showProductByName(String name) {
		// use  repo
		List<Product>  list=prodRepo.findByName(name);
		return list;
	}

	@Override
	public List<Product> showProductsByPriceRange(double start, double end) {
		List<Product>  list=prodRepo.findByPriceBetween(start, end);
		return list;
	}
	
	@Override
	public List<Product> fetchProductsByName(String name) {
		List<Product>  list=prodRepo.showProductsByName(name);
		return list;
	}
	
	@Override
	public List<Object[]> fetchProductsDataByName(String name) {
		List<Object[]>  list=prodRepo.showProductsDataByName(name);
		return list;
	}
	
	@Override
	public List<Product> fetchProductsByPriceRange(double start, double end) {
		return prodRepo.showProductsDataByPriceRange(start, end);
	}
	
	@Override
	public List<Product> fetchProductsByNamesIn(List<String> names) {
		return prodRepo.showProductsNameIn(names);
	}
	
	@Override
	public List<Product> fetchProductsByNameChars(String initChars) {
		return prodRepo.findByNameStartingWith(initChars);
	}
	
	


}
