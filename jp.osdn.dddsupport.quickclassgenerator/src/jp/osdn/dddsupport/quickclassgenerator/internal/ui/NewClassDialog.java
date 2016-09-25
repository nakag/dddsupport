package jp.osdn.dddsupport.quickclassgenerator.internal.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class NewClassDialog extends Dialog {

	private DataBindingContext m_bindingContext;
	private jp.osdn.dddsupport.quickclassgenerator.internal.ui.NewClass newClass = new jp.osdn.dddsupport.quickclassgenerator.internal.ui.NewClass();
	private Text classNameText;

	/**
	 * @wbp.parser.constructor
	 */
	public NewClassDialog(Shell parentShell) {
		super(parentShell);
	}

	public NewClassDialog(Shell parentShell, jp.osdn.dddsupport.quickclassgenerator.internal.ui.NewClass newNewClass) {
		super(parentShell);
		setNewClass(newNewClass, false);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));

		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		label.setText(Messages.NewClassDialog_0);

		classNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		classNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String s = ((Text)e.getSource()).getText();
				getButton(OK).setEnabled(s != null && s.length() > 0);
			}
		});
		classNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		if (newClass != null) {
			m_bindingContext = initDataBindings();
		}
		return container;
	}

	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		getButton(OK).setEnabled(false);
		getShell().setText(Messages.NewClassDialog_1);
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(250, 110);
	}

	private DataBindingContext initDataBindings() {
		IObservableValue classNameObserveWidget = SWTObservables.observeText(classNameText, SWT.Modify);
		IObservableValue classNameObserveValue = PojoObservables.observeValue(newClass, "className"); //$NON-NLS-1$
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(classNameObserveWidget, classNameObserveValue, null,
				new org.eclipse.core.databinding.UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));
		//
		return bindingContext;
	}

	public jp.osdn.dddsupport.quickclassgenerator.internal.ui.NewClass getNewClass() {
		return newClass;
	}

	public void setNewClass(jp.osdn.dddsupport.quickclassgenerator.internal.ui.NewClass newNewClass) {
		setNewClass(newNewClass, true);
	}

	public void setNewClass(jp.osdn.dddsupport.quickclassgenerator.internal.ui.NewClass newNewClass, boolean update) {
		newClass = newNewClass;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (newClass != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}

}
