package jp.osdn.dddsupport.basegenerator.model;

public class RepositoryInterface extends AbstractClass {

	public RepositoryInterface(PackageName packageName, ClassName className) {
		super(packageName, className);
	}

	@Override
	public String writeCode() {
		JavaSourceBuilder builder = new JavaSourceBuilder(packageName);
		return builder.interfaceName(className).build();
	}

}
