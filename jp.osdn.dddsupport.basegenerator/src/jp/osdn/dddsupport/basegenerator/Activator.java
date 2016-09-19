package jp.osdn.dddsupport.basegenerator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "jp.osdn.ddd.generator"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public static void showMessageDialog(String message) {
		MessageBox messageBox = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				SWT.ICON_INFORMATION | SWT.OK);
		messageBox.setText("Information");
		messageBox.setMessage(message);
		messageBox.open();
	}

	public static void showErrorDialog(Throwable t) {
		showErrorDialog("Error occur", t);
	}

	public static void log(Throwable t) {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.ERROR, t.getMessage(), t);
		getDefault().getLog().log(status);
		t.printStackTrace();
	}

	public static void showErrorDialog(String message, Throwable t) {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, 0, t.getMessage(), t);

		log(t);

		ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "エラー", message, status);
	}
}
