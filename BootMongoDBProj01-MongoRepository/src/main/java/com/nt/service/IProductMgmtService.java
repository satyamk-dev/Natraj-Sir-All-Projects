package com.nt.service;

import java.util.List;

import com.nt.document.Product;

public interface IProductMgmtService {
    public  String   saveProduct(Product prod);
    public  String    saveProducts(List<Product> prods);
    public   List<Product>  showAllProducts();
    public   Product    showProductId(String id);
    public String    updateProductPrice(String id,double hikePercent);
    public  String     removeProductsByNameAndCatetory(String name,String company);
}
