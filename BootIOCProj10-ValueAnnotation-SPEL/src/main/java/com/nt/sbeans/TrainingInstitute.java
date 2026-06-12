//TrainingInstitute.java
package com.nt.sbeans;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component("training")
public class TrainingInstitute {
	  //Inject hardcoded value
	@Value("10001")
	private Integer tid;
	 //  Inject  the values collected from the properties file
	@Value("${ti.name}")
	private  String  tname;
	@Value("${ti.addrs}")
	private  String  addrs;
	// Inject the system property values
	@Value("${user.name}")
	private  String   user;
	@Value("${os.name}")
	private  String osname;
	// Inject  the  env variable values
	@Value("${Path}")
	private  String pathData;
	
	//peform SPEL
	@Value("#{catalog.coreJavaPrice +catalog.advJavaPrice + catalog.spmbsPrice + catalog.awsPrice + catalog.devOpsPrice+ catalog.databasePrice + catalog.uiPrice+ catalog.testingPrice}")
	private Double fsjPrice;
	@Value("#{catalog.spmbsPrice >10000 }")
	private boolean isSpbmsPriceHigh;
	
	//@Autowired
	//@Resource
	@Value("#{catalog}")
	private CourseCatalog  catalog;
	
	public   double  finalFeel(double discountPercent) {
		double discount=fsjPrice*(discountPercent/100.0);
		return  fsjPrice-discount;
	}

	
	
	
	//toString()
	@Override
	public String toString() {
		return "TrainingInstitute [catalog=" + catalog + "]";
	}


}
