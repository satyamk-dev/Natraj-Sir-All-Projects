//BankAccount.java  (Enity class)
package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="BANK_ACCOUNT_VERSION_TIMESTAMP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
	//Data properties
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "ACNO_SEQ",initialValue = 10000000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Long acno;
	@Column(length = 30)
	@NonNull
	private  String  holderName;
	@Column(length = 30)
	@NonNull
	private   String bankName;
	@Column(length = 30)
	@NonNull
	private   String  branchName;
	@NonNull
	private  Double  balance;
	
	//  Meta Data properties
	@Column
	@Version  //for  versoning
	private  Integer  updateCount;
	
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDateTime  createdOn;
	
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private  LocalDateTime  lastUpdateOn;
	@Column(length = 30,insertable = true,updatable = false)
	private String createdBy;
	@Column(length = 30,insertable = false,updatable = true)
	private String  updateBy;
	@Column(length = 30)
	private  String active_SW="active";
	

}
