package com.groupeseb.kite.function.impl.lookup;

import com.groupeseb.kite.function.impl.JavaScriptHelper;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to excude javascript code.
 */
@Component
class JavaScriptLookupFunction extends AdditionalLookupFunction {
	private static final Pattern PATTERN = Pattern.compile("js:(.+?)", Pattern.CASE_INSENSITIVE);

	@Override
	public boolean match(String additionalParameter) {
		return PATTERN.matcher(additionalParameter).matches();
	}

	@Override
	public String apply(String input, String additionalParameter) {
		Matcher matcher = PATTERN.matcher(additionalParameter);
		//noinspection ResultOfMethodCallIgnored
		matcher.matches();
		String js = matcher.group(1);
		return JavaScriptHelper.eval(js, input);
	}
}
