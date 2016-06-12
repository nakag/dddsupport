package jp.osdn.dddsupport.basegenerator.model;

public abstract class AbstractClass {

	protected final PackageName packageName;
	protected ImportClasses importClasses = new ImportClasses();
	protected final ClassName className;

	public AbstractClass(PackageName packageName, ClassName className) {
		this.packageName = packageName;
		this.className = className;
	}

	public String toJavaFileName() {
		return className.toJavaFileName();
	}
	
	public abstract String writeCode();
}