//CustomerInfo.java
package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("custInfo")
@Data
@ConfigurationProperties(prefix = "cust.info")
public class CustomerInfo {
	private  String name;
	private  String  addrs;
	private   Integer  age;
	private  Double billamt;
	private  Double discount;

}
