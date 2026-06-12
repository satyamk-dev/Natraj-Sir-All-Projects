package com.nt.service;

import java.util.List;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;

public interface IContactDetailsMgmtService {
   public  String  savePersonAndHisPhoneNumbers(Person per);
   public  String  savePhoneNumbersAndAPerson(PhoneNumber ph1,PhoneNumber ph2);
   public  List<Person>   getPersonsAndTheirPhoneNumbers();
   public  List<PhoneNumber> getPhoneNumbersAndTheirPersons();
   public  String  removePersonAndHisPhoneNumbers(int pid);
   public  String  removePhoneNumbersAndAssociatedPerson(int regno1,int regno2);
   public  String  removeOnlyPhoneNumbersOfAPerson(int pid);
   public  String   addNewPhoneNumberToPerson(int pid,PhoneNumber ph);
   public  String movePhoneNumberFromOnePersonToAnotherPerson(int pid1,int pid2,Long phoneNo);
}
