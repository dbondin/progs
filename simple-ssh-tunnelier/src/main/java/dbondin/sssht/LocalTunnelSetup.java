package dbondin.sssht;


public class LocalTunnelSetup implements TunnelSetup {

	private int localPort;

	private String remoteHost;

	private int remotePort;

	public int getLocalPort() {
		return localPort;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public int getRemotePort() {
		return remotePort;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}

	@Override
	public String toString() {
		return "L" + localPort + ":" + remoteHost + ":" + remotePort;
	}
}
