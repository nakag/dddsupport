package jp.osdn.dddsupport.quickclassgenerator.internal.ui;

public class NewClass {
	private String className;
	private String packageName;
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String writeCode() {
		StringBuilder builder = new StringBuilder();
		builder.append("package ");
		builder.append(packageName);
		builder.append(";" + System.lineSeparator()+ System.lineSeparator());
		builder.append("public class ");
		builder.append(className);
		builder.append(" {" + System.lineSeparator());
		builder.append("}");
		return builder.toString();
	}
	public String toJavaFileName() {
		return this.className + ".java";
	}
}
