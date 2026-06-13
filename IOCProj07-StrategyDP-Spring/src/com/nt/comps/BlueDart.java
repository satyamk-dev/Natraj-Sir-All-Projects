package com.nt.comps;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("blueDart")
@Lazy(true)
public final class BlueDart implements ICourier {
	
	public BlueDart() {
		System.out.println("BlueDart:: 0-param construtor");
	}

	@Override
	public String deliver(int oid) {
		return oid+"order id  order items are  set for  delivery using  BlueDart Courier Service ";
	}

}
