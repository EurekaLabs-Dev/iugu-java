package com.iugu.enums;

import org.codehaus.jackson.annotate.JsonValue;

public enum ItemType {

	credit_card("credit_card");

	private String value;

	private ItemType(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
