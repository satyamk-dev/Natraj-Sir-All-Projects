package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

import jakarta.transaction.Transactional;

@Service
public class ContactDetailsMgmtServiceImpl implements IContactDetailsMgmtService {
	@Autowired
   private IPersonRepository  personRepo;
	@Autowired
	private  IPhoneNumberRepository phoneRepo;
	
	@Override
	public List<Object[]> showPersonAndPhoneNumbersData() {
		return personRepo.showDataByJoins();
	}

	@Override
	public List<Object[]> showPhoneNumberAndPersonData() {
		return phoneRepo.fetchDataUsingJoins();
	}
	
	
}
