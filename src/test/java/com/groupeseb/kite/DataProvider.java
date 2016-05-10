package com.groupeseb.kite;

import com.groupeseb.kite.function.impl.FunctionsProvider;

public final class DataProvider {

	private DataProvider() {
	}

	public static ContextProcessor newInternalContext() {
		return new ContextProcessor(FunctionsProvider.getFunctions(), new KiteContext());
	}

}
