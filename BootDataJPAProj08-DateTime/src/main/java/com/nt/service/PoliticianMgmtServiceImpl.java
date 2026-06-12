package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Politician;
import com.nt.repository.IPoliticianRepository;

@Service
public class PoliticianMgmtServiceImpl implements IPoliticianMgmtService {
	@Autowired
	private IPoliticianRepository politicianRepo;

	@Override
	public String savePolitician(Politician politician) {
		// use  repo
		int idVal=politicianRepo.save(politician).getPid();
		return "Politician is saved with id value ::"+idVal;
	}

	@Override
	public List<Politician> showAllPoliiticians() {
		return politicianRepo.findAll();
	}

	@Override
	public double showPoliticianAgeById(int id) {
		//use  service
		double  age=politicianRepo.calculateAgeById(id);
		return age;
	}

}
