package dbondin.sssht;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private ServerSetupPanel serverSetupPanel;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initGui();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initGui() {
		setTitle("Simple SSH Tunnelier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		setSize(320, 200);

		serverSetupPanel = new ServerSetupPanel();
		add(serverSetupPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));

	}

	private void onExitMenuItemActionPerformed() {
		System.exit(0);
	}
}
