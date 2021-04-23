package com.inminhouse.study.spring.ch05.property;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class CustomPropertyEditorRegister implements PropertyEditorRegistrar {

	private String datePattern;
	
	
	
	public String getDatePattern() {
		return datePattern;
	}



	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}



	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		CustomDateEditor propertyEditor = new CustomDateEditor(new SimpleDateFormat(datePattern), true);
		registry.registerCustomEditor(Date.class, propertyEditor);
	}
	
}
