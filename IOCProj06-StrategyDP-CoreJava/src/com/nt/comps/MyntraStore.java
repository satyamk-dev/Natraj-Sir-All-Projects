package com.nt.comps;

import java.util.Arrays;
import java.util.Random;

public class MyntraStore {
	//HAS -A property
	private   ICourier  courier;
	
	public MyntraStore() {
		System.out.println("MyntraStore:: 0-param constructor");
	}
	
	//setter method for injection
	public  void  setCourier(ICourier courier) {
		System.out.println("MyntraStore.setCourier()");
		this.courier=courier;
	}
	
	//b.method
	public   String    shopping(String[] items , float [] prices) {
		System.out.println("MyntraStore.shopping()");
	    //calculate bill amount
		float bamt=0.0f;
		for(int i=0;i<prices.length;++i)
			bamt=bamt+prices[i];
		
		//  generate the order id
		 int oid=new Random().nextInt(1000);
		 //use courier for items delivery
		 String msg=courier.deliver(oid);
		 //send message
		 return Arrays.toString(items)+" are purchased with prices:"+Arrays.toString(prices)+" having billamt::"+bamt+"--->"+msg;
	}

}
