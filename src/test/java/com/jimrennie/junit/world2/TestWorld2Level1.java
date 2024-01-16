package com.jimrennie.junit.world2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 2.1 Overview
 *
 * Mockito is a powerful and widely used mocking framework for Java. It offers easy mock object creation, behavior
 * verification, stubbing, and spying with an intuitive API.
 *
 * Instructions:
 * You have spent months building a {@link Human} class that uses the {@link Language} class to say various things.
 * See test instructions on test methods for further instruction.
 *
 */
class TestWorld2Level1 {

	/**
	 * Mocking is the practice of creating objects or components that simulate the behavior of real objects or
	 * dependencies. The purpose of mocking is to isolate the unit of code being tested.
	 *
	 * Instructions:
	 * You want to make sure your {@link Human} class can work with multiple languages. In the below test we have a
	 * Language mock setup, but no behaviours. Add a behaviour to your test to make {@link Language#hello()} return
	 * "Bonjour"
	 *
	 * Notes:
	 * To create a mock object in mockito, you can use {@link Mockito#mock(Class)}.
	 * To add behaviour to the mock you can use the {@link Mockito#when(Object)}
	 *
	 */
	@Test
	void testFrenchHello() {
		// Creates a mock Language. Usually mockito methods are static imported like assertions, so normally this would
		// be written like mock(Language.class) instead of Mockito.mock(Language.class).
		Language language = Mockito.mock(Language.class);

		// TODO Add mock behaviour here

		Human human = new Human(language);

		assertEquals("bonjour", human.sayHello());
	}

	/**
	 * Verifying refers to the process of confirming that specific interactions or behaviours have occurred during the
	 * execution of a test.
	 *
	 * Instructions:
	 * You want to make sure {@link Human#sayHelloWorld()} is actually calling {@link Language#hello()} method and
	 * {@link Language#world()} method. Verify that both methods are being called when {@link Human#sayHelloWorld()} is
	 * called.
	 *
	 * Notes:
	 * To verify you can use {@link Mockito#verify(Object)}
	 */
	@Test
	void testUsingCorrectLanguageMethods() {
		Language language = mock(Language.class);

		new Human(language).sayHelloWorld();

		// TODO Add verifies here
	}

	/**
	 * Spy refers to a hybrid between a real object and a mock object. A spy retains the real behaviour of the object
	 * while selectively mocking specific methods.
	 *
	 * Instructions:
	 * You are thinking of changing "hello" to "sup" in the {@link EnglishLanguage} but you want to make sure it will
	 * work when you call {@link Human#sayHelloWorld()}.
	 *
	 * 1. Convert {@link EnglishLanguage} into a spy
	 * 2. Replace the behaviour of the {@link Language#hello()} method on {@link EnglishLanguage} to return "sup"
	 *
	 * Notes:
	 * To spy an object you can use {@link Mockito#spy(Object)}
	 */
	@Test
	void testSpy() {
		// Add Spy to EnglishLanguage
		EnglishLanguage englishLanguage = new EnglishLanguage();

		// Replace behaviour here

		Human human = new Human(englishLanguage);

		assertEquals("sup world", human.sayHelloWorld());
	}

}
