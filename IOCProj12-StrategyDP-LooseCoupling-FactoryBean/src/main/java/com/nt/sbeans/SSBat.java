package com.nt.sbeans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("ssBat")
public  final class SSBat implements IBat {
	
	public SSBat() {
		System.out.println("SSBat:: 0-param constructor");
	}

	@Override
	public int scoreRuns() {
		System.out.println("SSBat.scoreRuns()");
		return new Random().nextInt(200);
	}

}
