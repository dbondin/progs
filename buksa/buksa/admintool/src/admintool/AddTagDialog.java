package admintool;

public class AddTagDialog extends javax.swing.JDialog {
    
    public AddTagDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);
        m_tag = null;
        
        return;
    }

    public admintool.entity.Tag showDialog() {
        m_tagPane.setData(new admintool.entity.Tag());
        m_tag = null;
        setVisible(true);
        return m_tag;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        m_tagPane = new admintool.TagPane();
        m_buttonsPane = new javax.swing.JPanel();
        m_okButton = new javax.swing.JButton();
        m_cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Добавить таг");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        m_tagPane.setShowButtons(false);
        m_tagPane.setShowTimes(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(m_tagPane, gridBagConstraints);

        m_buttonsPane.setLayout(new java.awt.GridBagLayout());

        m_okButton.setText("Добавить");
        m_okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_okButton, gridBagConstraints);

        m_cancelButton.setText("Отмена");
        m_cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(m_buttonsPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void m_okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_okButtonActionPerformed
    m_tag = m_tagPane.getTag();
    dispose();
}//GEN-LAST:event_m_okButtonActionPerformed

private void m_cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cancelButtonActionPerformed
    m_tag = null;
    dispose();
}//GEN-LAST:event_m_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel m_buttonsPane;
    private javax.swing.JButton m_cancelButton;
    private javax.swing.JButton m_okButton;
    private admintool.TagPane m_tagPane;
    // End of variables declaration//GEN-END:variables

    private admintool.entity.Tag m_tag;            
}
