package jp.osdn.dddsupport.basegenerator.internal.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import jp.osdn.dddsupport.basegenerator.model.AbstractClass;
import jp.osdn.dddsupport.basegenerator.model.BaseClass;
import jp.osdn.dddsupport.basegenerator.model.BaseClassModifier;
import jp.osdn.dddsupport.basegenerator.model.ClassName;
import jp.osdn.dddsupport.basegenerator.model.PackageName;
import jp.osdn.dddsupport.basegenerator.model.Workspace;

public class WorkspaceImpl implements Workspace {
	private IJavaElement baseClassPackageInWorkspace;
	private ICompilationUnit baseClassInWorkspace;

	public WorkspaceImpl(ExecutionEvent event) {
		baseClassInWorkspace = getUnit(event);
		baseClassPackageInWorkspace = baseClassInWorkspace.getParent();
	}

	public BaseClass getSelectedBaseClass() {
		PackageName packageName = new PackageName(baseClassPackageInWorkspace.getElementName());
		ClassName className = new ClassName(baseClassInWorkspace.getElementName());
		BaseClassModifier modifier = new BaseClassModifierImpl(baseClassInWorkspace);
		return new BaseClass(packageName, className, modifier);
	}

	private ICompilationUnit getUnit(ExecutionEvent event) {
		ICompilationUnit unit = null;
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection selectionFromExplorer = (IStructuredSelection) selection;
			unit = (ICompilationUnit) selectionFromExplorer.getFirstElement();
		}
		if (selection instanceof ITextSelection) {
			CompilationUnitEditor javaEditor = (CompilationUnitEditor) HandlerUtil.getActiveEditor(event);
			unit = (ICompilationUnit) javaEditor.getViewPartInput();
		}
		return unit;
	}

	@Override
	public boolean add(AbstractClass newClass) {
		IResource resource = baseClassPackageInWorkspace.getResource();
		IPath path = resource.getFullPath().append(newClass.toJavaFileName());

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = root.getFile(path);
		if (file.exists()) {
			System.out.println("file " + path + " is already exists.");
			return false;
		}

		InputStream in = null;
		try {
			in = new ByteArrayInputStream(newClass.writeCode().getBytes());
			file.create(in, false, null);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return false;
	}

}
