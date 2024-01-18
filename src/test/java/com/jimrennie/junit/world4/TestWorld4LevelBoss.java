package com.jimrennie.junit.world4;

import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;

/**
 * 4.boss
 *
 * Using only one assertJ assertion, test that the FRUIT has the following:
 * - name is banana
 * - toString is banana
 * - has the property key "water_content" with the value of "75%"
 */
class TestWorld4LevelBoss {

	private static final Fruit FRUIT = new Fruit()
			.setName("banana")
			.setSomePeopleThinkItsAVeggie(false)
			.addProperty("water_content", "75%")
			.addProperty("colour", "yellow");

	@Test
	void testBanana() {
		assertThat(FRUIT)
				.hasFieldOrPropertyWithValue("name", "banana")
				.hasToString("banana")
				.extracting(Fruit::getProperties, as(MAP))
				.containsEntry("water_content", "75%");
	}

	@Data
	@Accessors(chain = true)
	private static class Fruit {
		private String name;
		private boolean somePeopleThinkItsAVeggie;
		private Map<String, String> properties = new HashMap<>();

		Fruit addProperty(String key, String value) {
			properties.put(key, value);
			return this;
		}

		@Override
		public String toString() {
			return name;
		}

	}
}
