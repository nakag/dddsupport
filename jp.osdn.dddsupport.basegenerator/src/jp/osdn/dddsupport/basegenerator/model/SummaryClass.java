package jp.osdn.dddsupport.basegenerator.model;

public class SummaryClass extends AbstractClass {

	public SummaryClass(PackageName packageName, ClassName className) {
		super(packageName, className);
	}

	@Override
	public String writeCode() {
		JavaSourceBuilder builder = new JavaSourceBuilder(packageName);
		return builder.className(className).build();
	}

}
