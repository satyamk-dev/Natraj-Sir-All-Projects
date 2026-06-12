package com.nt.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExamResult {
	private  Integer id;
	private  LocalDateTime  dob;
	private  Float  percentage;
	private  Integer semester;

}
