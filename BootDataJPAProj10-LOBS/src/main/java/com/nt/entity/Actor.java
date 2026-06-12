//Actor.java
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="ACTOR_LOB")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer  aid;
	
	@Column(length = 30)
	@NonNull
	private  String  aname;
	
	@Column(length = 30)
	@NonNull
	private  String  addrs;
	
	@Lob
	@NonNull
	private  byte[]  photo;
	
	@Lob
	@NonNull
	private  char[]  resume;
	
	

}
