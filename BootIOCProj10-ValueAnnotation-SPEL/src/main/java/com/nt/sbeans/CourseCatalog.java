//CourseCatalog.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component("catalog")
@Getter
public class CourseCatalog {
	@Value("${cj.price}")
	private Double  coreJavaPrice;
	@Value("${aj.price}")
	private Double  advJavaPrice;
	@Value("${spbms.price}")
	private Double  spmbsPrice;
	@Value("${aws.price}")
	private Double  awsPrice;
	@Value("${devOps.price}")
	private Double  devOpsPrice;
	@Value("${ui.price}")
	private Double  uiPrice;
	@Value("${db.price}")
	private Double  databasePrice;
	@Value("${test.price}")
	private Double  testingPrice;
	
	//toString()  (alt+shift+s,s)
	@Override
	public String toString() {
		return "CourseCatalog [coreJavaPrice=" + coreJavaPrice + ", advJavaPrice=" + advJavaPrice + ", spmbsPrice="
				+ spmbsPrice + ", awsPrice=" + awsPrice + ", devOpsPrice=" + devOpsPrice + ", uiPrice=" + uiPrice
				+ ", databasePrice=" + databasePrice + ", testingPrice=" + testingPrice + "]";
	}
	
	
	

	

}
