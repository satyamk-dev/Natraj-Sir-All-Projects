package com.nt.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.Product;
import com.nt.document.Student;


@Service
public class ProductMgmtServiceImpl implements IProductMgmtService {
	@Autowired
	private  MongoTemplate  template;

	@Override
	public String saveProduct(Product prod) {
		//save the object
		String idVal=template.save(prod).getId();
		return "Product is saved with id value ::"+idVal;
	}

	@Override
	public String saveStudent(Student st) {
		String idVal=template.insert(st).getId();
		return "STudetn is saved with  id value :"+idVal;
	}
	
	@Override
	public String saveProducts(List<Product> list) {
		 //save the objects
		Iterable<Product> savedProds=template.insertAll(list);
		// get only id values
		List<String> ids=StreamSupport.stream(savedProds.spliterator(), false).map(Product::getId).toList();
		return  ids.size()+" Products are saved with id values ::"+ids;
	}
	
	@Override
	public List<Product> showProductsByPriceRange(double start, double end) {
		//prepare Query object
		Query query=new Query();
		query.addCriteria(Criteria.where("price").gte(start).lte(end));
		//get the docs
		List<Product> list=template.find(query,Product.class);
		return list;
	}
	
	  @Override
	    public List<Product> showProductsByCategory(String category) {
	        Query query = new Query();
	        query.addCriteria(Criteria.where("category").is(category));
	        return template.find(query, Product.class);
	    }
	
	  @Override
	public String updatePriceByCategory(String category, double hikePercent) {
		//Query object
		   Query query = new Query();
	        query.addCriteria(Criteria.where("category").is(category));
	      //prepare Update object
	        Update update=new Update();
	        update.multiply("price", hikePercent/100.0);
	        //execute the query
	        UpdateResult result=template.updateMulti(query, update, Product.class);
	        return  result.getModifiedCount()+"  no.of products are modified";
	}
	  
	  @Override
	public String removeProductsByPriceRange(double start, double end) {
		  //Query object
		  Query query=new Query();
		  query.addCriteria(Criteria.where("price").gte(start).lte(end));
		  //call the method
		  int count=template.findAllAndRemove(query, Product.class).size();
		return count+" no.of products are deleted";
	}
	  
	  @Override
	public String countProductsByCategory(String category) {
		//Query object
		  Query query=new Query();
		  query.addCriteria(Criteria.where("category").is(category));
		  //call the b.method
		  long count=template.count(query, Product.class);
		return count+" no.of  "+category+" Products are avaiable";
	}
	
}
