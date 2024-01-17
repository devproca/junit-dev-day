package com.jimrennie.junit.world3.core;

import lombok.experimental.UtilityClass;

import java.security.SecureRandom;

@UtilityClass
public class RandomCodeGenerator {

	private static final SecureRandom random = new SecureRandom();

	public static String generate() {
		return String.format("%05d", random.nextInt(100000));
	}

}
