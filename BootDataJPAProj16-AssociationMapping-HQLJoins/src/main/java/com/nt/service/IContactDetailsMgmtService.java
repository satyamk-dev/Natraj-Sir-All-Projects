package com.nt.service;

import java.util.List;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;

public interface IContactDetailsMgmtService {
	public  List<Object[]>  showPersonAndPhoneNumbersData();
	public  List<Object[]>  showPhoneNumberAndPersonData();
}
