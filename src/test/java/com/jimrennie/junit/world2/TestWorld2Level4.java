package com.jimrennie.junit.world2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 2.4 Argument captors
 *
 * ArgumentCaptor allows you to capture and inspect arguments passed to methods during the execution of your test. It is
 * particularly useful when working with mock objects and is often employed to verify method invocations with dynamic or
 * complex parameters.
 *
 * An argument captor can be created using the {@link ArgumentCaptor#forClass(Class)} or using the
 * annotation @Captor
 *
 * An argument captor can be used by calling {@link ArgumentCaptor#capture()} as the argument when mocking or verifying
 * a method.
 *
 * The value from the argument captor can be retrieved using {@link ArgumentCaptor#getValue()}.
 *
 * Instructions:
 * See test below
 */
@ExtendWith(MockitoExtension.class)
public class TestWorld2Level4 {

	@Mock
	private Language language;
	@Mock
	private IPhone iPhone;
	/*
	 * @InjectMocks automatically creates a new instance and injects mock objects into the fields of a tested object.
	 * Works great for Spring @Autowired variables.
	 *
	 * Behind the scenes it is running human = new Human(language, iPhone); during the beforeEach lifecycle hook.
	 */
	@InjectMocks
	private Human human;

	/**
	 * You added a function that allows the Human to text their friend "hello world". Unfortunately there isn't an easy
	 * way to test if it was actually sent because {@link Human#textFriendHelloWorld()} doesn't return anything.
	 *
	 * Instructions:
	 * Using an argument captor, capture the text input and assert that it equals "hello world"
	 *
	 */
	@Test
	void testHelloWorldTextMessageSentToIphone() {
		when(language.hello()).thenReturn("hello");
		when(language.world()).thenReturn("world");

		human.textFriendHelloWorld();

		verify(iPhone).text(null);
	}

}
