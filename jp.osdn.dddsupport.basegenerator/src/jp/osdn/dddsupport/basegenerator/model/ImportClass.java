package jp.osdn.dddsupport.basegenerator.model;

public class ImportClass {
	private String value;

	public ImportClass(String importClassName) {
		this.value = importClassName;
	}

	@Override
	public String toString() {
		return value;
	}
}
