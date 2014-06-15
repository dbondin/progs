package admintool;

import javax.swing.JOptionPane;

public class Main implements Runnable {

    public void run() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
    
    public static void main(String[] args) {

        if(!DataBase.getInstance().hasConnection()) {
            JOptionPane.showMessageDialog(null, "Database connection failed\nCheck " + DataBase.USER_PROPERTIES_FILE_NAME + " file settings\nAborting execution", "Buksa Admintool", JOptionPane.ERROR_MESSAGE);
            return;
        }

        javax.swing.SwingUtilities.invokeLater(new Main());
    }
}
