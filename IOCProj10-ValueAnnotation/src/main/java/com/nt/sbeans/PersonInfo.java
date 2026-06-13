//PersonInfo.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pInfo")
public class PersonInfo {
	//Collect the values from properties file
	@Value("${per.id}")
	private  Integer  id;
	@Value("${per.name}")
	private  String  name;
	@Value("${os.name}")
	private  String addrs;
	@Value("${per.age}")
	private  Integer age;
	
	//  inject hard coded values
	@Value("raja@rani.com")
	private  String email;
	
	//inject  system property values  (fixed keys)
	@Value("${os.name}")
	private   String osName;
	@Value("${os.version}")
	private  String osVersion;
	
	//inject  Env variable values  (fixed keys)
	@Value("${Path}")
	private   String pathData;

	
	
	//toString()
	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", name=" + name + ", addrs=" + addrs + ", age=" + age + ", email=" + email
				+ ", osName=" + osName + ", osVersion=" + osVersion + ", pathData=" + pathData + "]";
	}

}
