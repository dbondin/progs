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
import java.util.Date;

import javax.swing.ImageIcon;

public class MouseMoverApplication {
	
    public static final int SLEEP_TIMEOUT_MS = 60000;

    public static void main(String... args) throws Exception {
    	
        final Robot robot = new Robot();
        
    	Point previousMousePointerLocation = null;
    	int direction = 1;
    	
    	final boolean [] exitFlag = new boolean [] { false };
    	
    	if(SystemTray.isSupported()) {
    		final SystemTray systemTray = SystemTray.getSystemTray();
    		final TrayIcon trayIcon = new TrayIcon(new ImageIcon(MouseMoverApplication.class.getResource("icon.png")).getImage());
    		trayIcon.setToolTip("Mouse Mover");
    		PopupMenu popupMenu = new PopupMenu("Mouse Mover");
    		MenuItem menuItem = new MenuItem("Exit");
    		menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					exitFlag[0] = true;
				}
			});
    		popupMenu.add(menuItem);
    		trayIcon.setPopupMenu(popupMenu);
    		systemTray.add(trayIcon);
    	}
    	
        while (true) {
        	
        	Point mousePointerLocation = null;
        	
        	try {
        		mousePointerLocation = MouseInfo.getPointerInfo().getLocation();
        	}
        	catch(Throwable t) {
        		System.err.println(t);
        	}
        	
        	if(mousePointerLocation != null) {
        		if(previousMousePointerLocation != null) {
        			if(previousMousePointerLocation.equals(mousePointerLocation)) {
        				System.out.println("here 1");
        				try {
        					System.out.println(new Date());
        					robot.mouseMove(mousePointerLocation.x + direction, mousePointerLocation.y + direction);
        				}
        				catch(Throwable t) {
        					System.err.println(t);
        				}
        				
        				direction *= -1;
        				
            			try {
            				previousMousePointerLocation = MouseInfo.getPointerInfo().getLocation();
            			}
            			catch(Throwable t) {
            				System.err.println(t);
            			}
        			}
        			else {
        				System.out.println("here 2");
        				previousMousePointerLocation = mousePointerLocation;
        			}
        		}
        		else {
    				previousMousePointerLocation = mousePointerLocation;
        		}
        	}
        	
            try {
            	Thread.sleep(SLEEP_TIMEOUT_MS);
            }
            catch(Throwable t) {
            	System.err.println(t);
            }
            
            if(exitFlag[0]) {
            	break;
            }
        }
        
        System.exit(0);
    }
}
