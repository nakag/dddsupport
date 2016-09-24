package jp.osdn.dddsupport.quickclassgenerator.internal.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import jp.osdn.dddsupport.quickclassgenerator.internal.ui.NewClass;
import jp.osdn.dddsupport.quickclassgenerator.internal.ui.NewClassDialog;

public class QuickClassGenerateCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IPackageFragment packageInExplorer = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection selectionFromExplorer = (IStructuredSelection) selection;
			Object obj = selectionFromExplorer.getFirstElement();
			if (obj instanceof IPackageFragment) {
				packageInExplorer = (IPackageFragment) obj;
				NewClassDialog dialog = new NewClassDialog(HandlerUtil.getActiveShell(event));
				if (dialog.open() == Dialog.OK) {
					NewClass newClass = dialog.getNewClass();
					newClass.setPackageName(packageInExplorer.getElementName());

					System.out.println(newClass.getClassName());
					System.out.println(packageInExplorer.getElementName());
					
					IResource resource = packageInExplorer.getResource();
					IPath path =resource.getFullPath().append(newClass.toJavaFileName());
					System.out.println(path);
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IFile file = root.getFile(path);
					if (file.exists()) {
						System.out.println("file " + path + " is already exists.");
						return null;
					}

					InputStream in = null;
					try {
						in = new ByteArrayInputStream(newClass.writeCode().getBytes());
						file.create(in, false, null);
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
				}

			}
		}
		return null;
	}

}
