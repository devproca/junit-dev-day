package com.jimrennie.junit.world1;

public record Person(String firstName, String lastName) {

	public String displayName() {
		return firstName + " " + lastName;
	}
}
