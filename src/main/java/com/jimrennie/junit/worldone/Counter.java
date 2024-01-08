package com.jimrennie.junit.worldone;

import lombok.Getter;

public class Counter {

	private static final Counter INSTANCE = new Counter();

	@Getter
	private int count;

	private Counter() {
	}

	public Counter next() {
		count++;
		return this;
	}

	public void reset() {
		count = 0;
	}

	public static Counter getInstance() {
		return INSTANCE;
	}
}
