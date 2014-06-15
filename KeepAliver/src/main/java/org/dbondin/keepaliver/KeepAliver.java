/*********************************
 * PROPRIETARY/CONFIDENTIAL.  Use of this product is subject to license terms.
 * Copyright (c) 2014 NVision Group, Inc. All rights reserved.
 *
 * KeepAliver.java Jun 6, 2014 10:56:02 AM
 *********************************/
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
