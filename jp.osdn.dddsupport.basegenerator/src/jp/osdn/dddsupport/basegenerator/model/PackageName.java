package jp.osdn.dddsupport.basegenerator.model;

public class PackageName {
	private final String value;

	public PackageName(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public boolean isDefaultPackage() {
		return value.length() == 0;
	}
}
