package com.jimrennie.junit.worldone;

public record Person(String firstName, String lastName) {

	public String displayName() {
		return firstName + " " + lastName;
	}
}
