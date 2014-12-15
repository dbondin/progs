package dbondin.sssht;

import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SimpleSshTunnelier {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List<LookAndFeelInfo> lafList = Arrays.asList(UIManager
							.getInstalledLookAndFeels());
					for (LookAndFeelInfo i : lafList) {
						System.out.println(i.getName());
						if ("Nimbus".equals(i.getName())) {
							UIManager.setLookAndFeel(i.getClassName());
						}
					}
					MainWindow window = new MainWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
