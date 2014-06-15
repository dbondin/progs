package admintool;

import admintool.entity.FormatTitle;

public class AddBookDialog extends javax.swing.JDialog {

    public AddBookDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);
        m_bookInfo = null;
        return;
    }

    public admintool.entity.BookInfo showDialog(java.io.File file) {

        admintool.entity.BookInfo newBookInfo;
        String filename;
        String ext = null;
        int extIndex;

        java.util.List<FormatTitle> formats;

        if(file == null ||
           file.isFile() != true) {
            return null;
        }
        
        filename = file.getName();

        formats = DataBase.getInstance().getAllFormatTitles();

        /* file extension */
        extIndex = filename.lastIndexOf('.');
        if(extIndex > 0 && extIndex < filename.length() - 1) {
            ext = filename.substring(extIndex + 1).toLowerCase();
        }

        newBookInfo = new admintool.entity.BookInfo();
        newBookInfo.setFilename(filename);
        newBookInfo.setTitle(filename);

        if(ext != null) {
            for(FormatTitle f : formats) {
                String fext;

                try {
                    fext = DataBase.getInstance().getFormat(f.getId()).getExtension().toLowerCase();
                }
                catch(NullPointerException ex) {
                    fext = "";
                }

                if(ext.equals(fext)) {
                    newBookInfo.setFormat(f);
                    break;
                }
            }
        }

        m_bookPane.setData(newBookInfo, formats, DataBase.getInstance().getAllTagTitles());
        m_bookInfo = null;
        setVisible(true);
        return m_bookInfo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        m_bookPane = new admintool.BookPane();
        m_buttonsPane = new javax.swing.JPanel();
        m_okButton = new javax.swing.JButton();
        m_cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Добавить книгу");
        setMinimumSize(new java.awt.Dimension(500, 600));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        m_bookPane.setShowButtons(false);
        m_bookPane.setShowTimes(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(m_bookPane, gridBagConstraints);

        m_buttonsPane.setLayout(new java.awt.GridBagLayout());

        m_okButton.setText("Apply");
        m_okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_okButton, gridBagConstraints);

        m_cancelButton.setText("Cancel");
        m_cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(m_buttonsPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void m_okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_okButtonActionPerformed
    m_bookInfo = m_bookPane.getBookInfo();
    this.dispose();
}//GEN-LAST:event_m_okButtonActionPerformed

private void m_cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cancelButtonActionPerformed
    this.dispose();
}//GEN-LAST:event_m_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private admintool.BookPane m_bookPane;
    private javax.swing.JPanel m_buttonsPane;
    private javax.swing.JButton m_cancelButton;
    private javax.swing.JButton m_okButton;
    // End of variables declaration//GEN-END:variables

    private admintool.entity.BookInfo m_bookInfo;
    
}
