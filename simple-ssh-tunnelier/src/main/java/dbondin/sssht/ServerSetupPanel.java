package dbondin.sssht;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ServerSetupPanel extends JPanel {

	private static final long serialVersionUID = 8410863597161218927L;

	private JLabel loginLabel;

	private JTextField loginTextField;

	private JPasswordField passwordField;

	private JLabel passwordLabel;

	private JLabel portLabel;

	private JTextField portTextField;

	private JLabel serverLabel;

	private JTextField serverTextField;

	public ServerSetupPanel() {
		initGui();
	}

	public ServerSetup getServerSetup() {
		ServerSetup result = new ServerSetup();
		result.setServer(serverTextField.getText());
		result.setPort(Integer.parseInt(portTextField.getText()));
		result.setLogin(loginTextField.getText());
		result.setPassword(new String(passwordField.getPassword()));
		return result;
	}

	private void initGui() {
		setLayout(new GridBagLayout());
		setBackground(Color.YELLOW);

		serverLabel = new JLabel("Server");
		add(serverLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,
						4, 2, 4), 0, 0));

		serverTextField = new JTextField();
		add(serverTextField, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(2, 4, 2, 0), 0, 0));

		portLabel = new JLabel(":");
		add(portLabel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,
						0, 2, 0), 0, 0));

		portTextField = new JTextField(5);
		add(portTextField, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,
						0, 2, 4), 0, 0));

		loginLabel = new JLabel("Login");
		add(loginLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,
						4, 2, 4), 0, 0));

		loginTextField = new JTextField(10);
		add(loginTextField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,
						4, 2, 4), 0, 0));

		passwordLabel = new JLabel("Password");
		add(passwordLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,
						4, 2, 4), 0, 0));

		passwordField = new JPasswordField(10);
		add(passwordField, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,
						4, 2, 4), 0, 0));

		add(new JPanel(), new GridBagConstraints(0, 3, 4, 1, 1.0, 1.0,
				GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0,
						0, 0, 0), 0, 0));
	}

	public void setServerSetup(final ServerSetup serverSetup) {
		if (serverSetup != null) {
			serverTextField.setText(serverSetup.getServer());
			portTextField.setText("" + serverSetup.getPort());
			loginTextField.setText(serverSetup.getLogin());
			passwordField.setText(serverSetup.getPassword());
		} else {
			serverTextField.setText(null);
			portTextField.setText(null);
			loginTextField.setText(null);
			passwordField.setText(null);
		}
	}
}
