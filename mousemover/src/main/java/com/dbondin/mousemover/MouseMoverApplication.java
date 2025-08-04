package com.dbondin.mousemover;


public class MouseMoverApplication {
    public static void main(String... args) throws Exception {
    	new Thread(new MouseMoverRunnable()).start();
    }
}
