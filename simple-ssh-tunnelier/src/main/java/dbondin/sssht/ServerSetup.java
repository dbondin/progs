package dbondin.sssht;

public class ServerSetup {

	private String login;

	private String password;

	private int port;

	private String server;

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public int getPort() {
		return port;
	}

	public String getServer() {
		return server;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public void setServer(String server) {
		this.server = server;
	}
}
