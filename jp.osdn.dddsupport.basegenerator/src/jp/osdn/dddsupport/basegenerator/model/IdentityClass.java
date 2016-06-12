package jp.osdn.dddsupport.basegenerator.model;

public class IdentityClass extends AbstractClass {


	public IdentityClass(PackageName packageName, ClassName className) {
		super(packageName, className);
	}

	public Field toField() {
		return new Field(className);
	}
	
	@Override
	public String writeCode() {
		JavaSourceBuilder builder = new JavaSourceBuilder(packageName);
		return builder.className(className).build();
	}
}
