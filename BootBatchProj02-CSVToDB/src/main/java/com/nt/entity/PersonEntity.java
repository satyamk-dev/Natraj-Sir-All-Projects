package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="BATCH_PERSON")
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
	@Id
	private Integer  pid;
	
	@Column(length=30)
	private  String  firstName;
	@Column(length = 30)
	private  String lastName;
	private   Integer salary;
	

}
