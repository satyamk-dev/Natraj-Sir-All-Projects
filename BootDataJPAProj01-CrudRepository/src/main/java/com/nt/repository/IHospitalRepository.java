package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Hospital;

public interface IHospitalRepository extends CrudRepository<Hospital, Integer> {

}
