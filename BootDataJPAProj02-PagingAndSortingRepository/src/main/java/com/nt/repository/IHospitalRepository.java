package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Hospital;

public interface IHospitalRepository extends CrudRepository<Hospital, Integer>,
                                                                                         PagingAndSortingRepository<Hospital,Integer> {

}
