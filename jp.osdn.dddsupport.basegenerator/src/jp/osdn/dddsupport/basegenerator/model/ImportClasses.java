package jp.osdn.dddsupport.basegenerator.model;

import java.util.ArrayList;
import java.util.List;

public class ImportClasses {
	private List<ImportClass> importClasses;

	public ImportClasses() {
		importClasses = new ArrayList<ImportClass>();
	}

	public void add(ImportClass importClass) {
		if (importClasses.contains(importClass)) {
			return;
		}
		importClasses.add(importClass);
	}

	public List<ImportClass> getImportClasses() {
		return importClasses;
	}
}
