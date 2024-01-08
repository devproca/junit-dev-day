package com.jimrennie.junit.worldone;

import lombok.SneakyThrows;

public class Sleep {

	@SneakyThrows
	public static void forFiveSeconds() {
		Thread.sleep(5000);
	}

}
