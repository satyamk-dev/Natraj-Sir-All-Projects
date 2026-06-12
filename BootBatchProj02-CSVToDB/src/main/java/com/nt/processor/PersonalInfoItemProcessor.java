package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonEntity;

@Component
public class PersonalInfoItemProcessor implements ItemProcessor<PersonEntity, PersonEntity> {

	@Override
	public PersonEntity process(PersonEntity item) throws Exception {
		   if(item.getSalary()>=80000)
			   return  item;
		   else
	    	return null;
	}

}
