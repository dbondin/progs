package org.dbondin.keepaliver;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * @author Dmitry Bondin
 * 
 */
public class KeepAliver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (!java.awt.SystemTray.isSupported()) {
			JOptionPane.showMessageDialog(null,
					"SystemTray is not supported. Exiting", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainWindow mw = new MainWindow();

				mw.startPings();
			}
		});
	}

}
