package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	private  String id;
	private  Integer  pid;
	private  String  name;
	private   Double price;
	private   Double qty;
	private  String  category;
	private   String  company;

}
