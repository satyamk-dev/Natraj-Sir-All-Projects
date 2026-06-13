package com.nt.comps;


public final class BlueDart implements ICourier {
	
	public BlueDart() {
		System.out.println("BlueDart:: 0-param construtor");
	}

	@Override
	public String deliver(int oid) {
		return oid+"order id  order items are  set for  delivery using  BlueDart Courier Service ";
	}

}
