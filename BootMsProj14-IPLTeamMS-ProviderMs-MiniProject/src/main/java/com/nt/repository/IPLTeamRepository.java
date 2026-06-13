package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.IPLTeamEntity;

public interface IPLTeamRepository extends JpaRepository<IPLTeamEntity, Integer> {

}
