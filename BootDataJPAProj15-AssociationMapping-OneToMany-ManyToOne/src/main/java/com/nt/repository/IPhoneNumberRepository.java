package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PhoneNumber;

public interface IPhoneNumberRepository  extends  JpaRepository<PhoneNumber,Integer>{
}
