package com.jimrennie.junit.worldone.extension;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

import java.lang.reflect.Method;

@Slf4j
public class TimerExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

	private static final String START_TIME = "start time";

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		getStore(context).put(START_TIME, System.currentTimeMillis());
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		long startTime = getStore(context).remove(START_TIME, long.class);
		long duration = System.currentTimeMillis() - startTime;

		log.info("Test[{}] took {}ms.", context.getDisplayName(), duration);
	}

	private Store getStore(ExtensionContext context) {
		return context.getStore(Namespace.create(getClass(), context.getRequiredTestMethod()));
	}

}
