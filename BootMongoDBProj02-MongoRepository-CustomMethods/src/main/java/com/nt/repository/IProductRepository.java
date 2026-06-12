package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Product;

public interface IProductRepository extends MongoRepository<Product, String> {
    public   List<Product>  findByName(String name);
    public  List<Product>  findByPriceBetween(double start,double end);
    
    
    //@Query(value="{name:?0}")
    @Query(fields="{}" ,value="{name:?0}")
    public  List<Product>  showProductsByName(String  name);
    
    @Query(fields="{id:0,name:1 , price:1}",value="{name:?0}")
    public  List<Object[]>  showProductsDataByName(String  name);
    
    @Query("{ 'price': { $gte: ?0, $lte: ?1 } }")
    public  List<Product>  showProductsDataByPriceRange(double start,double end);
    
    @Query("{ 'name': { $in: ?0} }")
    List<Product> showProductsNameIn(List<String> names);
    
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Product> findByNameStartingWith(String prefix);
    
    
    
    
}
