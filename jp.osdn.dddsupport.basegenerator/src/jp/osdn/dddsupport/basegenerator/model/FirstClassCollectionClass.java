package jp.osdn.dddsupport.basegenerator.model;

public class FirstClassCollectionClass extends AbstractClass {
	private final Field collectionField;

	public FirstClassCollectionClass(PackageName packageName, ClassName className, AbstractClass fieldType, FieldName fieldName) {
		super(packageName, className);
		importClasses.add(new ImportClass("java.util.List"));
		this.collectionField = Field.builder().fieldType(new ClassName("List")).generics(fieldType).fieldName(fieldName).build();
	}

	@Override
	public String writeCode() {
		JavaSourceBuilder builder = new JavaSourceBuilder(packageName);
		return builder.includes(importClasses).className(className).field(collectionField).build();
	}
	
	
}
