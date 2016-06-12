package jp.osdn.dddsupport.basegenerator.model;

public class CriteriaClass {
	private PackageName packageName;
	private ClassName className;

	public CriteriaClass(PackageName packageName, ClassName className) {
		this.packageName = packageName;
		this.className = className;

	}

	public String toJavaFileName() {
		return className.toJavaFileName();
	}

	public String writeCode() {
		JavaSourceBuilder builder = new JavaSourceBuilder(packageName);
		return builder.className(className).build();
	}
}
