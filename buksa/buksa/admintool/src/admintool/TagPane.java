package admintool;

public class TagPane extends javax.swing.JPanel
                     implements IComponentStateChangeListener {

    public static final int ACTION_EVENT_APPLY = 0;
    
    public TagPane() {
        
        m_tag = null;
        
        m_actionEvent = new java.awt.event.ActionEvent(this, ACTION_EVENT_APPLY, "apply");
        m_actionListenersList = new java.util.Vector<java.awt.event.ActionListener>();

        initComponents();
        
        m_componentStateChangeController = new JComponentStateChangeController();
        
        m_componentStateChangeController.addComponentStateChangeListener(this);
        
        m_componentStateChangeController.addComponent(m_titleTextField);

        setShowButtons(true);
        setShowTimes(true);
        
        return;
    }

    public void componentStateChanged(JComponentStateChangeController controller, javax.swing.JComponent component) {
        m_undoButton.setEnabled(true);
        m_applyButton.setEnabled(true);
    }

    public void setData(admintool.entity.Tag tag) {
        m_tag = tag;
        updateGUIObjects();
        return;
    }
    
    public admintool.entity.Tag getTag() {
        updateTagObject();
        return m_tag;
    }
    
    private void updateTagObject() {
        if(m_tag == null) {
            return;
        }
        
        if(m_componentStateChangeController.isComponentStateChanged(m_titleTextField) == true) {
            m_tag.setTitle(m_titleTextField.getText());
        }
        return;
    }
    
    private void updateGUIObjects() {
        if(m_tag == null) {
            m_titleTextField.setText(null);
            m_ctimeText.setText(null);
            m_mtimeText.setText(null);
        }
        else {
            m_titleTextField.setText(m_tag.getTitle());
            m_ctimeText.setText((m_tag.getCTime() != null) ? m_tag.getCTime().toString() : null);
            m_mtimeText.setText((m_tag.getMTime() != null) ? m_tag.getMTime().toString() : null);
        }
    
        m_componentStateChangeController.setComponentStateChanged(false);
        
        m_undoButton.setEnabled(false);
        m_applyButton.setEnabled(false);
        
        return;
    }
    
    public boolean isShowButtons() {
        return m_showButtons;
    }

    public void setShowButtons(boolean showButtons) {
        this.m_showButtons = showButtons;
        
        m_buttonsPane.setVisible(m_showButtons);
        
        return;
    }

    public boolean isShowTimes() {
        return m_showTimes;
    }

    public void setShowTimes(boolean showTimes) {
        this.m_showTimes = showTimes;
        
        m_ctimeLabel.setVisible(m_showTimes);
        m_ctimeText.setVisible(m_showTimes);
        m_mtimeLabel.setVisible(m_showTimes);
        m_mtimeText.setVisible(m_showTimes);
        
        return;
    }

    public void addActionListener(java.awt.event.ActionListener actionListener) {
        m_actionListenersList.add(actionListener);
    }
    
    public void removeActionListener(java.awt.event.ActionListener actionListener) {
        m_actionListenersList.remove(actionListener);
    }
    
    protected void fireActionEvent() {
        for(java.awt.event.ActionListener l : m_actionListenersList) {
            l.actionPerformed(m_actionEvent);
        }
    }

    private void undoChanges() {
        setData(m_tag);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        m_componentStateChangeController = new admintool.JComponentStateChangeController();
        m_mainPane = new javax.swing.JPanel();
        m_titleLabel = new javax.swing.JLabel();
        m_ctimeLabel = new javax.swing.JLabel();
        m_mtimeLabel = new javax.swing.JLabel();
        m_fakePane = new javax.swing.JPanel();
        m_titleTextField = new javax.swing.JTextField();
        m_ctimeText = new javax.swing.JLabel();
        m_mtimeText = new javax.swing.JLabel();
        m_buttonsPane = new javax.swing.JPanel();
        m_undoButton = new javax.swing.JButton();
        m_applyButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        m_mainPane.setLayout(new java.awt.GridBagLayout());

        m_titleLabel.setText("Название:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_mainPane.add(m_titleLabel, gridBagConstraints);

        m_ctimeLabel.setText("Дата создания:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_mainPane.add(m_ctimeLabel, gridBagConstraints);

        m_mtimeLabel.setText("Дата модификации");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_mainPane.add(m_mtimeLabel, gridBagConstraints);

        javax.swing.GroupLayout m_fakePaneLayout = new javax.swing.GroupLayout(m_fakePane);
        m_fakePane.setLayout(m_fakePaneLayout);
        m_fakePaneLayout.setHorizontalGroup(
            m_fakePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );
        m_fakePaneLayout.setVerticalGroup(
            m_fakePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        m_mainPane.add(m_fakePane, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_mainPane.add(m_titleTextField, gridBagConstraints);

        m_ctimeText.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_mainPane.add(m_ctimeText, gridBagConstraints);

        m_mtimeText.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_mainPane.add(m_mtimeText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_mainPane, gridBagConstraints);

        m_buttonsPane.setLayout(new java.awt.GridBagLayout());

        m_undoButton.setText("Отменить изменения");
        m_undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_undoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_undoButton, gridBagConstraints);

        m_applyButton.setText("Применить изменения");
        m_applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_applyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_applyButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(m_buttonsPane, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

private void m_undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_undoButtonActionPerformed
    undoChanges();
}//GEN-LAST:event_m_undoButtonActionPerformed

private void m_applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_applyButtonActionPerformed
    fireActionEvent();
}//GEN-LAST:event_m_applyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_applyButton;
    private javax.swing.JPanel m_buttonsPane;
    private admintool.JComponentStateChangeController m_componentStateChangeController;
    private javax.swing.JLabel m_ctimeLabel;
    private javax.swing.JLabel m_ctimeText;
    private javax.swing.JPanel m_fakePane;
    private javax.swing.JPanel m_mainPane;
    private javax.swing.JLabel m_mtimeLabel;
    private javax.swing.JLabel m_mtimeText;
    private javax.swing.JLabel m_titleLabel;
    private javax.swing.JTextField m_titleTextField;
    private javax.swing.JButton m_undoButton;
    // End of variables declaration//GEN-END:variables

    private boolean m_showTimes;
    private boolean m_showButtons;
    
    private admintool.entity.Tag m_tag;
    
    private java.util.List<java.awt.event.ActionListener> m_actionListenersList;
    private java.awt.event.ActionEvent m_actionEvent;

}
