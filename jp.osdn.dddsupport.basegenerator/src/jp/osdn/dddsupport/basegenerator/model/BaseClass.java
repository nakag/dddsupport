package jp.osdn.dddsupport.basegenerator.model;

public class BaseClass extends AbstractClass {
	private Field identityField;
	private Field detailField;

	public BaseClass(PackageName packageName, ClassName className) {
		super(packageName, className);
		this.identityField = toIdentityClass().toField();
		this.detailField = toDetailClass().toField();
	}

	public IdentityClass toIdentityClass() {
		return new IdentityClass(packageName, className.appendClassName("Identity"));
	}

	public DetailClass toDetailClass() {
		return new DetailClass(packageName, className.appendClassName("Detail"));
	}

	public CriteriaClass toCriteriaClass() {
		return new CriteriaClass(packageName, className.appendClassName("Criteria"));
	}

	public FirstClassCollectionClass toFirstClassCollectionClass() {
		return new FirstClassCollectionClass(packageName, className.appendClassName("s"), toSummaryClass(),
				new FieldName("sumarry"));
	}

	public SummaryClass toSummaryClass() {
		return new SummaryClass(packageName, className.appendClassName("Summary"));
	}

	public RepositoryInterface toRepositoryInterface() {
		return new RepositoryInterface(packageName, className.appendClassName("Repository"));
	}

	public TypeEnum toTypeEnum() {
		return new TypeEnum(packageName, className.appendClassName("Type"));
	}

	@Override
	public String writeCode() {
		JavaSourceBuilder builder = new JavaSourceBuilder(packageName);
		return builder.className(className).build();
	}

}
