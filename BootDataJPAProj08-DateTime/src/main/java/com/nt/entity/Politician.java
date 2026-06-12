
package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Politician {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer pid;
	@NonNull
	@Column(length = 30)
	private  String pname;
	@NonNull
	@Column(length = 30)
	private   String party;
	@NonNull
	private  LocalDate dob;
	@NonNull
	private   LocalTime tob;
	@NonNull
	private  LocalDateTime doj;
	

}
