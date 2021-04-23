package com.inminhouse.study.spring.ch05.property;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 00 클래스의 PropertyEditor가 구현된 00Editor 클래스가 같은 패키지 내에 있을 경우
 * 문자열을 00 타입으로 변환할 때 00Editor가 사용된다.
 * @author inye
 *
 */
public class MoneyEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Pattern pattern = Pattern.compile("([0-9]+)([A-Z]{3})");
		Matcher matcher = pattern.matcher(text);
		if(!matcher.matches()) {
			throw new IllegalArgumentException("invalid format");
		}
		int amount = Integer.parseInt(matcher.group(1));
		String currency = matcher.group(2);
		setValue(new Money(amount, currency));
	}

}
