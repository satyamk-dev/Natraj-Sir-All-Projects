package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("college")
@ConfigurationProperties(prefix = "clg.info")
@ToString
@Setter
public class CollegeDetails {
	private  Integer cid;
	private  String  cname;
	private  String addrs;
	private  Integer strengh;
	private  String email;
	
	private  String[]  favColors;
	private  List<String>  friends;
	private  Set<Long> phones;
	private   Map<String,Object> idDetails;
	private  University university;
	

}
