package org.dbondin.keepaliver;

public class Settings {
	
	private String host;
	private int port;
	private int delay;
	
	public Settings() {
		this.host = "localhost";
		this.port = 1234;
		this.delay = 1;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
}
