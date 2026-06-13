package com.nt.comps;


public final class DHL implements ICourier {
	
	public DHL() {
		System.out.println("DHL:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return oid+"order id  order items are  set for  delivery using  DHL Courier Service ";
	}

}
