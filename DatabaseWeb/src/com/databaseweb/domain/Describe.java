package com.databaseweb.domain;

public class Describe {

	private String field;
	private String type;
	private String nullable;
	private String key;
	private String defaultValue;
	private String extra;
	
	public Describe() {
		super();
	}

	public Describe(String field, String type, String nullable, String key, String defaultValue, String extra) {
		super();
		this.field = field;
		this.type = type;
		this.nullable = nullable;
		this.key = key;
		this.defaultValue = defaultValue;
		this.extra = extra;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "Describe [field=" + field + ", type=" + type + ", nullable=" + nullable + ", key=" + key
				+ ", defaultValue=" + defaultValue + ", extra=" + extra + "]";
	}
	
}
