package org.dbondin.keepaliver;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * @author Dmitry Bondin
 * 
 */
public class MainWindow extends JDialog {

	private static final long serialVersionUID = 5579395730063073798L;

	public MainWindow() {
		super();

		initializeComponents();
	}

	public void setMessage(final String message) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				messageLabel.setText(message);
			}
		});
	}

	private void initializeComponents() {

		Image icon = new ImageIcon(getClass().getResource("KeepAliver.png"))
				.getImage();

		setSize(320, 200);
		setTitle("KeepAliver");
		setIconImage(icon);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

		messageLabel = new JLabel();
		getContentPane().add(messageLabel);

		PopupMenu menu = new PopupMenu("KeepAliver");

		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemTray.getSystemTray().remove(trayIcon);
				System.exit(0);
			}
		});
		menu.add(miExit);

		trayIcon = new TrayIcon(icon, "KeepAliver", menu);

		try {
			SystemTray.getSystemTray().add(trayIcon);
		} catch (AWTException ex) {
			JOptionPane.showMessageDialog(null,
					"Error adding icon in System Tray. Exiting", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		trayIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(!isVisible());
			}
		});
	}

	public synchronized void startPings() {
		if (thr == null) {
			thr = new Thread("KeepAliver-Pings-Thread") {
				@Override
				public void run() {
					
					DatagramSocket ds = null;
					
					try {

						List<String> addresses = new ArrayList<String>();

						for (NetworkInterface ni : Collections
								.list(NetworkInterface.getNetworkInterfaces())) {
							for (InetAddress ia : Collections.list(ni
									.getInetAddresses())) {
								if (ia instanceof Inet4Address) {
									String strIp = ia.getHostAddress();
									if (!"127.0.0.1".equals(strIp)) {
										addresses.add(ia.getHostAddress());
									}
								}
							}
						}

						StringBuilder sb = new StringBuilder();

						sb.append("KEEP_ALIVER\r\n");
						for (String strIp : addresses) {
							sb.append(strIp).append("\r\n");
						}

						String message = sb.toString();

						ds = new DatagramSocket();

						DatagramPacket dp = new DatagramPacket(
								message.getBytes(), message.getBytes().length,
								InetAddress.getByName("applmath.ru"), 1234);

						while (true) {
							ds.send(dp);
							setMessage("LAST PING: " + new Date());
							Thread.sleep(60000);
						}
					} catch (Throwable t) {
						setMessage("ERROR: " + t.getMessage());
					}
					finally {
						try {
							ds.close();
						}
						catch(Throwable t) {
							/* Ignore */
						}
					}
				};
			};

			thr.start();
		}
	}

	private TrayIcon trayIcon;
	private JLabel messageLabel;
	private Thread thr = null;
}
