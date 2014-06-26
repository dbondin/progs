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
		
		final Settings settings = new Settings();
		
		if(args.length > 0) {
			settings.setHost(args[0]);
			if(args.length > 1) {
				settings.setPort(Integer.parseInt(args[1]));
				if(args.length > 2) {
					settings.setDelay(Integer.parseInt(args[2]));
				}
			}
		}
		
		if (!java.awt.SystemTray.isSupported()) {
			JOptionPane.showMessageDialog(null,
					"SystemTray is not supported. Exiting", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainWindow mw = new MainWindow(settings);
				mw.setLocationRelativeTo(null);
				mw.startPings();
			}
		});
	}

}
