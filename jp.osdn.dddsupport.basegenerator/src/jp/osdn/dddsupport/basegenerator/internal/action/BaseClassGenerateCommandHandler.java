package jp.osdn.dddsupport.basegenerator.internal.action;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;

import jp.osdn.dddsupport.basegenerator.model.BaseClass;
import jp.osdn.dddsupport.basegenerator.model.DetailClass;
import jp.osdn.dddsupport.basegenerator.model.FirstClassCollectionClass;
import jp.osdn.dddsupport.basegenerator.model.IdentityClass;
import jp.osdn.dddsupport.basegenerator.model.RepositoryInterface;
import jp.osdn.dddsupport.basegenerator.model.SummaryClass;
import jp.osdn.dddsupport.basegenerator.model.TypeEnum;
import jp.osdn.dddsupport.basegenerator.model.Workspace;

public class BaseClassGenerateCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		System.out.println("select class is " + selection.getClass());

		Workspace workspace = new WorkspaceImpl(event);
		BaseClass baseClass = workspace.getSelectedBaseClass();
		SummaryClass summaryClass = baseClass.toSummaryClass();
		FirstClassCollectionClass collection = baseClass.toFirstClassCollectionClass();
		IdentityClass identityClass = baseClass.createIdentityClass();
		DetailClass detailClass = baseClass.toDetailClass();
		RepositoryInterface repositoryInterface = baseClass.toRepositoryInterface();
		TypeEnum typeEnum = baseClass.toTypeEnum();

		workspace.add(summaryClass);
		workspace.add(collection);
		workspace.add(identityClass);
		workspace.add(detailClass);
		workspace.add(repositoryInterface);
		workspace.add(typeEnum);

		return null;
	}

}
