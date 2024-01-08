package com.jimrennie.junit.world1;

import lombok.SneakyThrows;

public class Sleep {

	@SneakyThrows
	public static void forFiveSeconds() {
		Thread.sleep(5000);
	}

}
