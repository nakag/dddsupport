package jp.osdn.dddsupport.basegenerator.model;

public class JavaSourceBuilder {
	private StringBuilder builder = new StringBuilder();
	private static final String LINE_END = ";";
	private static final String LINE_FEED = System.lineSeparator();

	public JavaSourceBuilder(PackageName packageName) {
		if (!packageName.isDefaultPackage()) {
			builder.append("package ");
			builder.append(packageName);
			builder.append(LINE_END).append(LINE_FEED).append(LINE_FEED);
		}
	}

	public JavaSourceBuilder includes(ImportClasses packages) {
		for (ImportClass ic : packages.getImportClasses()) {
			builder.append("import ").append(ic).append(LINE_END).append(LINE_FEED);
		}
		builder.append(LINE_FEED);
		return this;
	}

	public JavaSourceBuilder className(ClassName className) {
		builder.append("public class ");
		builder.append(className);
		builder.append(" {");
		builder.append(LINE_FEED);

		return this;
	}

	public JavaSourceBuilder interfaceName(ClassName interfaceName) {
		builder.append("public interface ");
		builder.append(interfaceName);
		builder.append(" {");
		builder.append(LINE_FEED);

		return this;
	}

	public JavaSourceBuilder enumName(ClassName enumName) {
		builder.append("public enum ");
		builder.append(enumName);
		builder.append(" {");
		builder.append(LINE_FEED);

		return this;
	}

	public JavaSourceBuilder field(Field field) {
		builder.append("private ").append(field);
		builder.append(LINE_END).append(LINE_FEED);

		return this;
	}

	public String build() {
		builder.append("}");
		return builder.toString();
	}
}
