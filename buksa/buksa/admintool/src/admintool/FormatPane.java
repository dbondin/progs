package admintool;

import javax.swing.JComponent;

public class FormatPane extends javax.swing.JPanel
                        implements IComponentStateChangeListener{

    public static final int ACTION_EVENT_APPLY = 0;
    
    public FormatPane() {
        m_showTimes = true;
        m_showButtons = true;
        m_format = null;
        m_actionEvent = new java.awt.event.ActionEvent(this, ACTION_EVENT_APPLY, "apply");
        m_actionListeners = new java.util.Vector<java.awt.event.ActionListener>();
        initComponents();
        m_stateChangeController = new JComponentStateChangeController();
        m_stateChangeController.addComponentStateChangeListener(this);
        m_stateChangeController.addComponent(m_titleTextField);
        m_stateChangeController.addComponent(m_descriptionTextArea, m_descriptionScrollPane);
        m_stateChangeController.addComponent(m_extensionTextField);
        m_stateChangeController.addComponent(m_mimeTypeTextField);
        return;
    }

    public boolean isShowButtons() {
        return m_showButtons;
    }

    public void setShowButtons(boolean showButtons) {
        m_showButtons = showButtons;
        
        m_butonsPane.setVisible(m_showButtons);
        
        return;
    }

    public boolean isShowTimes() {
        return m_showTimes;
    }

    public void setShowTimes(boolean showTimes) {
        m_showTimes = showTimes;
        
        m_ctimeLabel.setVisible(m_showTimes);
        m_ctimeText.setVisible(m_showTimes);
        m_mtimeLabel.setVisible(m_showTimes);
        m_mtimeText.setVisible(m_showTimes);
        
        return;
    }

    public void setFormat(admintool.entity.Format format) {
        m_format = format;
        updateGUIObjects();
        
        return;
    }

    public void componentStateChanged(JComponentStateChangeController controller, JComponent component) {
        m_undoButton.setEnabled(true);
        m_applyButton.setEnabled(true);
    }

    private void updateGUIObjects() {

        if(m_format == null) {
            m_titleTextField.setText(null);
            m_ctimeText.setText(null);
            m_mtimeText.setText(null);
            m_extensionTextField.setText(null);
            m_mimeTypeTextField.setText(null);
            m_descriptionTextArea.setText(null);
        }
        else {
            m_titleTextField.setText(m_format.getTitle());
            m_ctimeText.setText((m_format.getCTime() != null) ? m_format.getCTime().toString() : null);
            m_mtimeText.setText((m_format.getMTime() != null) ? m_format.getMTime().toString() : null);
            m_extensionTextField.setText(m_format.getExtension());
            m_mimeTypeTextField.setText(m_format.getMimeType());
            m_descriptionTextArea.setText(m_format.getDescription());
        }
    
        m_stateChangeController.setComponentStateChanged(false);
        
        m_undoButton.setEnabled(false);
        m_applyButton.setEnabled(false);
        
        return;
    }

    
    private java.awt.event.ActionEvent m_actionEvent;
    
    private void fireActionEvent() {
        for(java.awt.event.ActionListener l : m_actionListeners) {
            l.actionPerformed(m_actionEvent);
        }
    }
    
    private void undoChanges() {
        setFormat(m_format);
    }

    public void addActionListener(java.awt.event.ActionListener actionListener) {
        m_actionListeners.add(actionListener);
    }
    
    public void removeActionListener(java.awt.event.ActionListener actionListener) {
        m_actionListeners.remove(actionListener);
    }
    
    public admintool.entity.Format getFormat() {
        updateFormatObject();
        return m_format;
    }

    private void updateFormatObject() {
        if(m_format == null) {
            return;
        }
        
        if(m_stateChangeController.isComponentStateChanged(m_titleTextField) == true) {
            m_format.setTitle(m_titleTextField.getText());
        }
        
        if(m_stateChangeController.isComponentStateChanged(m_descriptionTextArea) == true) {
            m_format.setDescription(m_descriptionTextArea.getText());
        }
        
        if(m_stateChangeController.isComponentStateChanged(m_extensionTextField) == true) {
            m_format.setExtension(m_extensionTextField.getText());
        }
        
        if(m_stateChangeController.isComponentStateChanged(m_mimeTypeTextField) == true) {
            m_format.setMimeType(m_mimeTypeTextField.getText());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        m_titleLabel = new javax.swing.JLabel();
        m_descriptionLabel = new javax.swing.JLabel();
        m_extensionLabel = new javax.swing.JLabel();
        m_mimeTypeLabel = new javax.swing.JLabel();
        m_ctimeLabel = new javax.swing.JLabel();
        m_mtimeLabel = new javax.swing.JLabel();
        m_titleTextField = new javax.swing.JTextField();
        m_extensionTextField = new javax.swing.JTextField();
        m_mimeTypeTextField = new javax.swing.JTextField();
        m_descriptionScrollPane = new javax.swing.JScrollPane();
        m_descriptionTextArea = new javax.swing.JTextArea();
        m_ctimeText = new javax.swing.JLabel();
        m_mtimeText = new javax.swing.JLabel();
        m_fakePane = new javax.swing.JPanel();
        m_butonsPane = new javax.swing.JPanel();
        m_applyButton = new javax.swing.JButton();
        m_undoButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        m_titleLabel.setText("Название:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_titleLabel, gridBagConstraints);

        m_descriptionLabel.setText("Описание:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_descriptionLabel, gridBagConstraints);

        m_extensionLabel.setText("Расширение:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_extensionLabel, gridBagConstraints);

        m_mimeTypeLabel.setText("MIME-Тип:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_mimeTypeLabel, gridBagConstraints);

        m_ctimeLabel.setText("Дата создания:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_ctimeLabel, gridBagConstraints);

        m_mtimeLabel.setText("Дата модификации:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_mtimeLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_titleTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_extensionTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_mimeTypeTextField, gridBagConstraints);

        m_descriptionTextArea.setColumns(20);
        m_descriptionTextArea.setFont(new java.awt.Font("Tahoma", 0, 11));
        m_descriptionTextArea.setLineWrap(true);
        m_descriptionTextArea.setRows(4);
        m_descriptionTextArea.setWrapStyleWord(true);
        m_descriptionScrollPane.setViewportView(m_descriptionTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_descriptionScrollPane, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_ctimeText, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_mtimeText, gridBagConstraints);

        javax.swing.GroupLayout m_fakePaneLayout = new javax.swing.GroupLayout(m_fakePane);
        m_fakePane.setLayout(m_fakePaneLayout);
        m_fakePaneLayout.setHorizontalGroup(
            m_fakePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );
        m_fakePaneLayout.setVerticalGroup(
            m_fakePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(m_fakePane, gridBagConstraints);

        m_butonsPane.setLayout(new java.awt.GridBagLayout());

        m_applyButton.setText("Применить изменения");
        m_applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_applyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_butonsPane.add(m_applyButton, gridBagConstraints);

        m_undoButton.setText("Отменить изменения");
        m_undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_undoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_butonsPane.add(m_undoButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(m_butonsPane, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

private void m_applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_applyButtonActionPerformed
    fireActionEvent();
}//GEN-LAST:event_m_applyButtonActionPerformed

private void m_undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_undoButtonActionPerformed
    undoChanges();
}//GEN-LAST:event_m_undoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_applyButton;
    private javax.swing.JPanel m_butonsPane;
    private javax.swing.JLabel m_ctimeLabel;
    private javax.swing.JLabel m_ctimeText;
    private javax.swing.JLabel m_descriptionLabel;
    private javax.swing.JScrollPane m_descriptionScrollPane;
    private javax.swing.JTextArea m_descriptionTextArea;
    private javax.swing.JLabel m_extensionLabel;
    private javax.swing.JTextField m_extensionTextField;
    private javax.swing.JPanel m_fakePane;
    private javax.swing.JLabel m_mimeTypeLabel;
    private javax.swing.JTextField m_mimeTypeTextField;
    private javax.swing.JLabel m_mtimeLabel;
    private javax.swing.JLabel m_mtimeText;
    private javax.swing.JLabel m_titleLabel;
    private javax.swing.JTextField m_titleTextField;
    private javax.swing.JButton m_undoButton;
    // End of variables declaration//GEN-END:variables

    private JComponentStateChangeController m_stateChangeController;
    private java.util.List<java.awt.event.ActionListener> m_actionListeners;
    private admintool.entity.Format m_format;
    
    private boolean m_showButtons;
    private boolean m_showTimes;
            
}
