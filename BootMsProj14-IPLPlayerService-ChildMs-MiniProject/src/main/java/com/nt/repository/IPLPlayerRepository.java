package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.IPLPlayerEntity;

public interface IPLPlayerRepository extends JpaRepository<IPLPlayerEntity,Integer> {

}
