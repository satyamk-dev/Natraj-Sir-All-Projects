package com.nt.comps;


public final class DTDC implements ICourier {
	
	
	public DTDC() {
		System.out.println("DTDC:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return oid+"order id  order items are  set for  delivery using  DTDC Courier Service ";
	}

}
