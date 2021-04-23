package com.inminhouse.study.spring.ch05.conversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;

import com.inminhouse.study.spring.ch05.property.Money;

public class StringToMoneyConverter implements Converter<String, Money>{

	@Override
	public Money convert(String source) {
		Pattern pattern = Pattern.compile("([0-9]+)([A-Z]{3})");
		Matcher matcher = pattern.matcher(source);
		if(!matcher.matches()) {
			throw new IllegalArgumentException("invalid format");
		}
		int amount = Integer.parseInt(matcher.group(1));
		String currency = matcher.group(2);
		return new Money(amount, currency);
	}

	
}
