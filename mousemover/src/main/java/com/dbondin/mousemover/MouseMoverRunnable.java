package com.dbondin.mousemover;

import java.awt.MenuItem;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class MouseMoverRunnable implements Runnable {

	public static final long DEFAULT_SLEEP_TIMEOUT_MS = TimeUnit.MINUTES.toMillis(1); // 1 minute sleep timeout
	public static final long DEFAULT_RUNNING_TINMEOUT_MS = TimeUnit.HOURS.toMillis(8); // 8 hours before exit the program

	private final long sleepTimeoutMs;
	private final long runningTimeoutMs;
	
	public MouseMoverRunnable() {
		this(DEFAULT_SLEEP_TIMEOUT_MS, DEFAULT_RUNNING_TINMEOUT_MS);
	}
	
	public MouseMoverRunnable(final long sleepTimeoutMs, final long runningTimeoutMs) {
		this.sleepTimeoutMs = sleepTimeoutMs;
		this.runningTimeoutMs = runningTimeoutMs;
	}
	
	@Override
	public void run() {

		try {

			final Robot robot = new Robot();

			Point previousMousePointerLocation = null;
			int direction = 1;

			MenuItem statusMenuItem = null;
			
			if (SystemTray.isSupported()) {
				final SystemTray systemTray = SystemTray.getSystemTray();
				final TrayIcon trayIcon = new TrayIcon(
						new ImageIcon(MouseMoverApplication.class.getResource("icon.png")).getImage());
				trayIcon.setToolTip("Mouse Mover");
				PopupMenu popupMenu = new PopupMenu("Mouse Mover");
				statusMenuItem = new MenuItem("--- ? / ? ---");
				statusMenuItem.setEnabled(false);
				MenuItem exitMenuItem = new MenuItem("Exit");
				exitMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				popupMenu.add(statusMenuItem);
				popupMenu.add(exitMenuItem);
				trayIcon.setPopupMenu(popupMenu);
				systemTray.add(trayIcon);
			}

			long startTime = System.currentTimeMillis();

			System.out.println("Starting process");
			
			while ((startTime + runningTimeoutMs) > System.currentTimeMillis()) {

				if(statusMenuItem != null) {
					Duration left = Duration.ofMillis((startTime + runningTimeoutMs) - System.currentTimeMillis());
					statusMenuItem.setLabel("--- " + String.format("%d:%02d", 
							left.toHours(), 
							left.toMinutes() - TimeUnit.HOURS.toMinutes(left.toHours())) + " ---");
				}
				
				Point mousePointerLocation = null;

				try {
					mousePointerLocation = MouseInfo.getPointerInfo().getLocation();
				} catch (Throwable t) {
					System.err.println(t);
				}

				if (mousePointerLocation != null) {
					if (previousMousePointerLocation != null) {
						if (previousMousePointerLocation.equals(mousePointerLocation)) {
							try {
								robot.mouseMove(mousePointerLocation.x + direction, mousePointerLocation.y + direction);
							} catch (Throwable t) {
								System.err.println(t);
							}

							direction *= -1;

							try {
								previousMousePointerLocation = MouseInfo.getPointerInfo().getLocation();
							} catch (Throwable t) {
								System.err.println(t);
							}
						} else {
							previousMousePointerLocation = mousePointerLocation;
						}
					} else {
						previousMousePointerLocation = mousePointerLocation;
					}
				}

				try {
					Thread.sleep(sleepTimeoutMs);
				} catch (Throwable t) {
					System.err.println(t);
				}
			}
			
			System.out.println("Finishing process due RUNNING_TINMEOUT_MS (" + runningTimeoutMs + ")");
			
		} catch (Throwable t) {
			System.err.println(t);
			System.exit(1);
		}
		
		System.exit(0);
	}
}
