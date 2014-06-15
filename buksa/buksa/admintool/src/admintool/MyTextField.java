package admintool;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyTextField extends javax.swing.JTextField {
    
    public MyTextField() {
        super();
        
        getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void removeUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }

}
