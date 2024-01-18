package com.jimrennie.junit.world5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

/**
 * 5.boss
 *
 * The database table you're testing uses a long as its primary key. You want the ability to inject a unique long into
 * your test, so you can stop worrying about creating unique ids and get to testing.
 *
 * Instructions:
 * Create an extension that injects a unique long as a parameter into the test. The long should be unique to this test
 * class, not all test classes.
 *
 * Hint:
 * You will need to use the data store in the extension context. The store is hierarchical so each test has a store and
 * the test class has a store.
 */
@ExtendWith(TestWorld5LevelBoss.UniqueIdExtension.class)
class TestWorld5LevelBoss {

	@Test
	void test1(Long id) {
		System.out.printf("test1 - id: %s%n", id);
	}

	@Test
	void test2(long id) {
		System.out.printf("test2 - id: %s%n", id);
	}

	@Test
	void test3(Long id1, long id2) {
		System.out.printf("test3 - id1: %s id2: %s%n", id1, id2);
	}

	public static class UniqueIdExtension implements BeforeAllCallback, ParameterResolver {

		private static final Namespace NAMESPACE = Namespace.create(UniqueIdExtension.class);
		private static final String UNIQUE_ID_KEY = "uniqueid";

		@Override
		public void beforeAll(ExtensionContext context) throws Exception {
			setId(context, -1L);
		}

		@Override
		public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
			Class<?> type = parameterContext.getParameter().getType();
			return long.class == type || Long.class == type;
		}

		@Override
		public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
			return getNextId(extensionContext);
		}

		private void setId(ExtensionContext context, long id) {
			context.getParent().orElse(context).getStore(NAMESPACE).put(UNIQUE_ID_KEY, id);
		}

		private long getNextId(ExtensionContext context) {
			long nextId = getId(context) + 1;
			setId(context, nextId);
			return nextId;
		}

		private long getId(ExtensionContext context) {
			return context.getParent().orElse(context).getStore(NAMESPACE).get(UNIQUE_ID_KEY, long.class);
		}
	}

}
