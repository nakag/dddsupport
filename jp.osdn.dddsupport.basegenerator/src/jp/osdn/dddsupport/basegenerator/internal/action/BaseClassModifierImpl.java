package jp.osdn.dddsupport.basegenerator.internal.action;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

import jp.osdn.dddsupport.basegenerator.model.BaseClassModifier;
import jp.osdn.dddsupport.basegenerator.model.Field;

public class BaseClassModifierImpl implements BaseClassModifier {
	private ICompilationUnit baseClassInWorkspace;

	public BaseClassModifierImpl(ICompilationUnit baseClassInWorkspace) {
		this.baseClassInWorkspace = baseClassInWorkspace;
	}

	@Override
	public void addField(Field field) {
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setSource(baseClassInWorkspace);
		try {
			IType[] types = baseClassInWorkspace.getTypes();
			IType top = types[0];
			top.createField("private " + field.toString() + ";", null, true, new NullProgressMonitor());
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

}
