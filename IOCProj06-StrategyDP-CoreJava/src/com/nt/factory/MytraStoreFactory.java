//Factory Pattern class
package com.nt.factory;

import com.nt.comps.BlueDart;
import com.nt.comps.DHL;
import com.nt.comps.DTDC;
import com.nt.comps.ICourier;
import com.nt.comps.MyntraStore;

public class MytraStoreFactory {

	//public static factory method having  factory pattern logic
	public static   MyntraStore  getInstance(String  courierName) {
		//create Dependent class object
		ICourier courier=null;
		if(courierName.equalsIgnoreCase("dtdc"))
			courier=new DTDC();
		else if(courierName.equalsIgnoreCase("dhl"))
			courier=new DHL();
		else if(courierName.equalsIgnoreCase("bDart"))
			courier=new BlueDart();
		else 
			throw new IllegalArgumentException("Invalid Courier Service");
		//create target spring bean class object
		MyntraStore  store=new MyntraStore();
		//inject  courier object (dependdent) to  target object
		store.setCourier(courier);
		return store;
	}
}
