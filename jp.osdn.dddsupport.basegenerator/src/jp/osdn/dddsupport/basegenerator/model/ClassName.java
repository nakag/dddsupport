package jp.osdn.dddsupport.basegenerator.model;

public class ClassName {
	private final String value;

	public ClassName(String value) {
		int extention = value.indexOf(".java");
		if (extention > 0) {
			value = value.substring(0, extention);
		}
		this.value = value;
	}

	public ClassName appendClassName(String suffix) {
		return new ClassName(this.value + suffix);
	}

	public FieldName toFieldName() {
		return new FieldName(this.value.substring(0, 1).toLowerCase() + this.value.substring(1));
	}

	public String toJavaFileName() {
		return this.value + ".java";
	}

	public String toString() {
		return value;
	}
}
