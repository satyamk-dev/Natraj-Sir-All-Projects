//Student.java
package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	@Id
	private  String id;
	private Integer sno;
	private  String  sname;
	private  String sadd;
	private  Double avg;

}
