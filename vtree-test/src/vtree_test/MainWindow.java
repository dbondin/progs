package vtree_test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
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
		
		add(vtreePane, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(4, 4, 4, 4), 0, 0));
		
		resetButton = new JButton("Reset");
		
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onResetButtonActionPerformed(e);
			}
		});
		
		add(resetButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(4, 4, 4, 4), 0, 0));
	}
	
	private void onResetButtonActionPerformed(ActionEvent e) {
		vtreePane.reset();
	}
	
	private VTreePane vtreePane;
	private JButton resetButton;
}
