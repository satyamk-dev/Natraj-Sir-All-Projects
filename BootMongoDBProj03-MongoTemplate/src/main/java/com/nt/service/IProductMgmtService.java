package com.nt.service;

import java.util.List;

import com.nt.document.Product;
import com.nt.document.Student;

public interface IProductMgmtService {
     public  String  saveProduct(Product prod);
     public  String  saveStudent(Student st);
     public   String  saveProducts(List<Product> list);
     public  List<Product>  showProductsByPriceRange(double start, double end);
     public  List<Product>  showProductsByCategory(String category);
     public    String   updatePriceByCategory(String category,double hikePercent);
     public   String   removeProductsByPriceRange(double  start,double end);
     public   String    countProductsByCategory(String category);
}
