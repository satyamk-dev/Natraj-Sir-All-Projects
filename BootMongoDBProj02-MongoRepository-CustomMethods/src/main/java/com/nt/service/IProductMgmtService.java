package com.nt.service;

import java.util.List;

import com.nt.document.Product;

public interface IProductMgmtService {
      public  List<Product> showProductByName(String name);
      public   List<Product>  showProductsByPriceRange(double start,double end);
      
      public   List<Product>   fetchProductsByName(String name);
      public  List<Object[]>   fetchProductsDataByName(String name);
      public   List<Product>  fetchProductsByPriceRange(double start,double end);
      public   List<Product>   fetchProductsByNamesIn(List<String> names);
      public  List<Product>  fetchProductsByNameChars(String initChars);
      
}
