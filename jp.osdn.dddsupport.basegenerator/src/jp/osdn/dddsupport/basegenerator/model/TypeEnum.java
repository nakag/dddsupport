package jp.osdn.dddsupport.basegenerator.model;

public class TypeEnum extends AbstractClass {

	public TypeEnum(PackageName packageName, ClassName className) {
		super(packageName, className);
	}

	@Override
	public String writeCode() {
		JavaSourceBuilder builder = new JavaSourceBuilder(packageName);
		return builder.enumName(className).build();
	}

}
