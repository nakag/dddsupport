package jp.osdn.dddsupport.basegenerator.model;

public interface Workspace {
	BaseClass getSelectedBaseClass();
	boolean add(AbstractClass newClass);
}
