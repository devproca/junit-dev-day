package com.jimrennie.junit.world2;

public class Human {

	private final Language language;
	private final IPhone iPhone;

	public Human(Language language) {
		this.language = language;
		this.iPhone = null;
	}

	public Human(Language language, IPhone iPhone) {
		this.language = language;
		this.iPhone = iPhone;
	}

	public String sayHello() {
		return language.hello();
	}

	public String sayHelloWorld() {
		return language.hello() + " " + language.world();
	}

	public void textFriendHelloWorld() {
		if (iPhone == null) {
			throw new RuntimeException("Human does not have iphone :(");
		}

		iPhone.text(sayHelloWorld());
	}


}
