package jp.osdn.dddsupport.basegenerator.internal.action;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

import jp.osdn.dddsupport.basegenerator.Activator;
import jp.osdn.dddsupport.basegenerator.model.BaseClassModifier;
import jp.osdn.dddsupport.basegenerator.model.Field;

public class BaseClassModifierImpl implements BaseClassModifier {
	private ICompilationUnit baseClassInWorkspace;

	public BaseClassModifierImpl(ICompilationUnit baseClassInWorkspace) {
		this.baseClassInWorkspace = baseClassInWorkspace;
	}

	@Override
	public void addField(Field field) {
		try {
			@SuppressWarnings("deprecation")
			ASTParser parser = ASTParser.newParser(AST.JLS3);

			parser.setSource(baseClassInWorkspace);

			IType[] types = baseClassInWorkspace.getTypes();
			IType top = types[0];
			top.createField("private " + field.toString() + ";", null, true, new NullProgressMonitor());
		} catch (Exception e) {
			Activator.showErrorDialog(e);
		}
		
	}

}
