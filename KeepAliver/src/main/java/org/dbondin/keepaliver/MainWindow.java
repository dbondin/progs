package org.dbondin.keepaliver;

import java.awt.AWTException;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * @author Dmitry Bondin
 * 
 */
public class MainWindow extends JDialog {

	private static final long serialVersionUID = 5579395730063073798L;

	private final Settings settings;

	public MainWindow(Settings settings) {
		super();

		this.settings = settings;

		initializeComponents();
	}

	public static final int MAX_LOG_LINES = 10;

	public void setMessage(final String message) {

		if (logList.size() >= MAX_LOG_LINES) {
			logList.pop();
		}
		logList.add(message);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// messageLabel.setText(message);
				StringBuilder sb = new StringBuilder();
				for (String s : logList) {
					sb.append(s).append('\n');
				}
				String text = sb.toString();
				logTextArea.setText(text);
				logTextArea.setCaretPosition(text.length());
			}
		});
	}

	private static final String DEFAULT_TRAY_ICON_FILE_NAME = "KeepAliver-16x16.png";

	private void initializeComponents() {

		String trayIconFileName = DEFAULT_TRAY_ICON_FILE_NAME;
		Image trayIconImage = null;

		/* Determine the tray icon prefered size */
		Dimension trayIconSize = SystemTray.getSystemTray().getTrayIconSize();
		if (trayIconSize != null) {
			trayIconFileName = "KeepAliver-" + trayIconSize.width + "x"
					+ trayIconSize.height + ".png";
		}

		try {
			trayIconImage = new ImageIcon(getClass().getResource(
					trayIconFileName)).getImage();
		} catch (Throwable t) {
			trayIconImage = new ImageIcon(getClass().getResource(
					DEFAULT_TRAY_ICON_FILE_NAME)).getImage();
		}

		setSize(320, 200);
		setTitle("KeepAliver");
		setIconImage(trayIconImage);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

		// messageLabel = new JLabel();
		// getContentPane().add(messageLabel);

		Container cp = getContentPane();
		cp.setLayout(new GridBagLayout());

		JLabel hostPortLabel = new JLabel("Target: " + settings.getHost() + ":"
				+ settings.getPort());
		cp.add(hostPortLabel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		JLabel delayLabel = new JLabel("Delay: " + settings.getDelay() + " sec");
		cp.add(delayLabel, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		logTextArea = new JTextArea();
		logTextArea.setEditable(false);
		JScrollPane scr = new JScrollPane(logTextArea);
		cp.add(scr, new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0,
				GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2,
						2, 2, 2), 0, 0));

		PopupMenu menu = new PopupMenu("KeepAliver");

		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemTray.getSystemTray().remove(trayIcon);
				System.exit(0);
			}
		});
		menu.add(miExit);

		trayIcon = new TrayIcon(trayIconImage, "KeepAliver", menu);

		try {
			SystemTray.getSystemTray().add(trayIcon);
		} catch (AWTException ex) {
			JOptionPane.showMessageDialog(null,
					"Error adding icon in System Tray. Exiting", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		trayIcon.addActionListener(new ActionListener() {
			@Override
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
							try {
								ds.send(dp);
							} catch (IOException ioex) {
								setMessage("ERROR: " + ioex.getMessage());
								setMessage("WILL RETRY");
							}

							setMessage("LAST PING: " + new Date());
							Thread.sleep(settings.getDelay() * 1000);
						}
					} catch (Throwable t) {
						setMessage("ERROR: " + t.getMessage());
						setMessage("FINISHED");
					} finally {
						try {
							ds.close();
						} catch (Throwable t) {
							/* Ignore */
						}
					}
				}
			};

			thr.start();
		}
	}

	private TrayIcon trayIcon;
	private JTextArea logTextArea;
	private final LinkedList<String> logList = new LinkedList<String>();
	private Thread thr = null;
}
