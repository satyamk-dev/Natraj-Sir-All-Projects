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
	public String savePersonAndHisPhoneNumbers(Person per) {
		//save object
		int idVal=personRepo.save(per).getPid();
		return "PErson and His PhoneNumbers are Saved with id Value::"+idVal;
	}

	@Override
	public String savePhoneNumbersAndAPerson(PhoneNumber ph1, PhoneNumber ph2) {
		//use repo
	     List<PhoneNumber>  list=phoneRepo.saveAll(List.of(ph1,ph2));
	     List<Integer>  ids=list.stream().map(PhoneNumber::getRegNo).collect(Collectors.toList());
	   return "PhoneNumbers are saved with id Values::"+ids;
	}

	@Override
	public List<Person> getPersonsAndTheirPhoneNumbers() {
		return  personRepo.findAll();
	}
	
	@Override
	public List<PhoneNumber> getPhoneNumbersAndTheirPersons() {
		return phoneRepo.findAll();
	}
	
	@Override
	public String removePersonAndHisPhoneNumbers(int pid) {
		//Load parent object
		Optional<Person>  opt=personRepo.findById(pid);
		if(opt.isPresent()) {
			//get Parent object
			  Person per=opt.get();
			  //delete the parent object its  associated objects
			  personRepo.delete(per);
			  return pid+" Person  and its childs objs are deleted";
		}
		else {
			return pid+" Person is not found for deletion";
		}
	}
	
	@Override
	public String removePhoneNumbersAndAssociatedPerson(int regno1, int regno2) {
		// Load  childs
		List<PhoneNumber>  list=phoneRepo.findAllById(List.of(regno1,regno2));
		if(list.size()!=0) {
			 phoneRepo.deleteAll(list);
			 return  regno1+","+regno2+" PhoneNumbers and the Associated PErson details are deleted";
		}
		return  regno1+"or"+ regno2+" Phone Numbers are not found for deletion";
	}
	@Override
	public String removeOnlyPhoneNumbersOfAPerson(int pid) {
	
		//Load parent object
		Optional<Person>  opt=personRepo.findById(pid);
		if(opt.isPresent()) {
	          // get childs of a parent
			Person per=opt.get();
			Set<PhoneNumber>  list=per.getPhones();
			 //remove only childs
			phoneRepo.deleteAllInBatch(list);
			return  pid+" person  Phone Numbers are deleted";
		}
		else {
			return  pid+" Person  is not found";
		}
	}

	@Override
	//@Transactional
	public String addNewPhoneNumberToPerson(int pid,PhoneNumber ph) {
		//Load  person object
		Person per=personRepo.findById(pid).orElseThrow(()->new IllegalArgumentException("Invalid pid"));
		//get existing phones
		Set<PhoneNumber>  phones=per.getPhones();
	    // link new phone number existing person
		ph.setPer(per);
		//add new phoneNumbers to existing person
		phones.add(ph);
		 //update the person
		personRepo.save(per);
		  
		 return  "new Phone Number is added to existing Person";
	}
	
	@Override
	public String movePhoneNumberFromOnePersonToAnotherPerson(int pid1, int pid2, Long phoneNo) {
		//Load  person1 object
		Person per1=personRepo.findById(pid1).orElseThrow(()->new IllegalArgumentException("Invalid pid"));
		//Load  person2 object
		Person per2=personRepo.findById(pid2).orElseThrow(()->new IllegalArgumentException("Invalid pid"));
		//get PhoneNumbers of person1
		Set<PhoneNumber>  phones=per1.getPhones();
		// check for givne phoneNumber availality
		PhoneNumber ph = phones.stream()
		        .filter(p -> p.getPhoneNo().equals(phoneNo))
		        .findFirst()
		        .orElse(null);
		//change person of the phoneNumber
		ph.setPer(per2);
		//save/update the ph objecvt
		phoneRepo.save(ph);
		return "PhoneNumber  obj is moved from "+pid1+" to "+pid2;
	}

}
