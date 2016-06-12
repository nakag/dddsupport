package jp.osdn.dddsupport.basegenerator.model;

public class Field {
	private ClassName fieldType;
	private FieldName fieldName;
	private AbstractClass genericsType;
	
	protected Field() {
		
	}
	public Field(ClassName fieldType) {
		this.fieldType = fieldType;
		this.fieldName = fieldType.toFieldName();
	}

	public Field(ClassName fieldType, FieldName fieldName) {
		this.fieldType = fieldType;
		this.fieldName = fieldName;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(fieldType);
		if (genericsType != null) {
			builder
				.append("<")
				.append(genericsType.className)
				.append(">");
		}
		builder.append(" ");
		builder.append(fieldName);
		return builder.toString();
		
	}
	public static Builder builder() {
		return new Builder();
	}
	protected static class Builder {
		private Field field;
		public Builder() {
			field =new Field();
		}
		public Builder fieldType(ClassName fieldTypeClass) {
			field.fieldType = fieldTypeClass;
			return this;
		}
		public Builder fieldName(FieldName fieldName) {
			field.fieldName = fieldName;
			return this;
		
		}
		public Builder generics(AbstractClass genericsClass) {
			field.genericsType = genericsClass;
			return this;
		}
		public Field build() {
			return this.field;
		}
	}
}
