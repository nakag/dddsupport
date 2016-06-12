package jp.osdn.dddsupport.basegenerator.model;

public class FieldName {
	private String value;

	public FieldName(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
