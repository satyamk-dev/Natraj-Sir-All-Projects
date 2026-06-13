package com.nt.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class SeasonMgmtServiceImpl implements ISeasonMgmtService {

	@Override
	public String findSeason() {
		//get  season name
		LocalDate  ldate=LocalDate.now();
		//get current  month  value
		int month=ldate.getMonthValue();
		//generate the season name
		if(month>=3 && month<=6)
			return "Summer Season";
		else if(month>=7 && month<=10)
			return "Rainy Season";
		else
			return "Winter Season";
	}
	
	

}
