package com.inminhouse.study.spring.ch05.property;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomDateEditor extends PropertyEditorSupport {
	
	private SimpleDateFormat format;

	public CustomDateEditor(SimpleDateFormat format, boolean is) {
		this.format = format;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			setValue(format.parse(text));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
