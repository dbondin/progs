package vtree_test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3618775695006019761L;

	private VTreePane vtreePane;

	private JButton resetButton;

	private JCheckBox antialiasCheckBox;

	public MainWindow() {
		initGui();
	}

	private void initGui() {
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("VTree Test");
		setLayout(new GridBagLayout());

		vtreePane = new VTreePane();
		vtreePane.setBorder(BorderFactory.createEtchedBorder());

		add(vtreePane, new GridBagConstraints(0, 0, 1, 2, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						4, 4, 4, 4), 0, 0));

		resetButton = new JButton("Reset");

		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onResetButtonActionPerformed(e);
			}
		});

		add(resetButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL,
				new Insets(4, 4, 4, 4), 0, 0));

		antialiasCheckBox = new JCheckBox("Antialias",
				vtreePane.isAntialiased());

		antialiasCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				onAntialiasCheckBoxStateChanged(e);
			}
		});

		add(antialiasCheckBox, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL,
				new Insets(4, 4, 4, 4), 0, 0));
	}

	private void onAntialiasCheckBoxStateChanged(ItemEvent e) {
		vtreePane.setAntialiased(e.getStateChange() == ItemEvent.SELECTED);
	}

	private void onResetButtonActionPerformed(ActionEvent e) {
		vtreePane.reset();
	}
}
