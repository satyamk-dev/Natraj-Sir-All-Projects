package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class ExamResult {
	@Id
	private  Integer id;
	private  String   dob;
	private   Float  percentage;
	private   Integer  semester;
}
