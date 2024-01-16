package com.jimrennie.junit.world2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 2.2 Mockito setup
 *
 * There are a few different ways to set up mockito for tests. With a basic setup you can use the Mockito methods to
 * mock / spy on a class. A more advanced set up allows you to use annotations to create mocks and spies.
 *
 * Instructions:
 * You don't have to do anything for this test. Just look through each setup.
 */
class TestWorld2Level2 {

	/**
	 * Basic setup using mockito methods to mock a class
	 */
	@Nested
	class BasicSetup {

		private final Language language = mock(Language.class);

		@Test
		void test() {
			Human human = new Human(language);

			when(language.hello()).thenReturn("ciao");

			assertEquals("ciao", human.sayHello());
		}
	}

	/**
	 * Setup so that the @Mock and @Spy annotations can be used. MockitoAnnotations.openMocks(this) must be
	 * called for the annotations to work.
	 */
	@Nested
	class AnnotationsSetup {

		@Mock
		private Language language;

		private AutoCloseable mockitoAutoCloseable;

		@BeforeEach
		void setUp() {
			mockitoAutoCloseable = MockitoAnnotations.openMocks(this);
		}

		@AfterEach
		void tearDown() throws Exception {
			mockitoAutoCloseable.close();
		}

		@Test
		void test() {
			Human human = new Human(language);

			when(language.hello()).thenReturn("hola");

			assertEquals("hola", human.sayHello());
		}

	}


	/**
	 * Setup using the {@link MockitoExtension} so that the @Mock and @Spy annotations can be used.
	 */
	@Nested
	@ExtendWith(MockitoExtension.class)
	class AnnotationsSetupUsingMockitoExtension {

		@Mock
		private Language language;

		@Test
		void test() {
			Human human = new Human(language);

			when(language.hello()).thenReturn("namaste");

			assertEquals("namaste", human.sayHello());
		}

	}
}
