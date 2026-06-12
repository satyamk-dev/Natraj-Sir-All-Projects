package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.PhoneNumber;

public interface IPhoneNumberRepository  extends  JpaRepository<PhoneNumber,Integer>{
	
	@Query("select  ph.regNo,ph.phoneNo,ph.type,ph.provider,p.pid,p.pname,p.addrs from PhoneNumber ph right join ph.per p")
	public    List<Object[]>  fetchDataUsingJoins();
}
