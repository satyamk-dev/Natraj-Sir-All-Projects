package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PersonEntity;

public interface IPersonalInfoRepository extends JpaRepository<PersonEntity, Integer> {

}
