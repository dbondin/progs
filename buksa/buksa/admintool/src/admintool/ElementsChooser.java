package admintool;

public class ElementsChooser extends javax.swing.JPanel {

    public ElementsChooser() {
        
        m_selectedElementsListModel = new ElementsListModel();
        m_deselectedElementsListModel = new ElementsListModel();
        
        initComponents();
        
        m_listeners = new java.util.Vector<IElementsChooserListener>();
        
        setElements(null);
        
        return;
    }

    public void addElementChooserListener(IElementsChooserListener listener) {
        if(listener == null ||
           m_listeners.contains(listener)) {
            return;
        }
        
        m_listeners.add(listener);
        
        return;
    }
    
    public void removeElementChooserListener(IElementsChooserListener listener) {
        if(listener == null) {
            return;
        }
        
        m_listeners.remove(listener);
        
        return;
    }
    
    private void notifyListeners() {
        for(IElementsChooserListener l : m_listeners) {
            l.elementChooserActionPerformed(this);
        }
        
        return;
    }
    
    public void setElements(java.util.List elements) {
        m_elements = elements;
        
        if(m_elements == null) {
            m_selectedElements = null;
            m_deselectedElements = null;
        }
        else {
            m_selectedElements = new java.util.Vector();
            m_deselectedElements = new java.util.Vector(m_elements);
        }
        
        m_selectedElementsListModel.setElements(m_selectedElements);
        m_deselectedElementsListModel.setElements(m_deselectedElements);
        
        updateButtons();
        
        return;
    }

    public void setElements(java.util.List elements, java.util.List selected) {
        setElements(elements);
        selectElements(selected);
        
        return;
    }
    
    public void selectElement(Object element) {
        if(m_elements == null) {
            return;
        }
        
        if(m_deselectedElements.contains(element)) {
            m_deselectedElements.remove(element);
            m_deselectedElementsListModel.fireContentsChanged();
            
            m_selectedElements.add(element);            
            m_selectedElementsListModel.fireContentsChanged();
            
            updateButtons();
        }
        
        return;
    }
    
    public void selectElements(java.util.List elements) {
        if(elements == null) {
            return;
        }
        
        for(Object e : elements.toArray()) {
            selectElement(e);
        }
        
        return;
    }
    
    public void deselectElements(java.util.List elements) {
        if(elements == null) {
            return;
        }
        
        for(Object e : elements.toArray()) {
            deselectElement(e);
        }
        
        return;
    }
    
    public void deselectElement(Object element) {
        if(m_elements == null) {
            return;
        }
        
        if(m_selectedElements.contains(element)) {
            m_selectedElements.remove(element);
            m_selectedElementsListModel.fireContentsChanged();

            m_deselectedElements.add(element);
            m_deselectedElementsListModel.fireContentsChanged();
            
            updateButtons();
        }
        
        return;
    }
    
    public java.util.List getSelectedElements() {
        return m_selectedElements;
    }
            
    public java.util.List getDeselectedElements() {
        return m_deselectedElements;
    }
    
    public java.util.List getElements() {
        return m_elements;
    }
    
    private void addElement() {
        if(m_deselectedList.getSelectedValues() == null) {
            return;
        }
        
        for(Object e : m_deselectedList.getSelectedValues()) {
            selectElement(e);
        }
        notifyListeners();
        return;
    }
    
    private void deleteElement() {
        if(m_selectedList.getSelectedValues() == null) {
            return;
        }
        
        for(Object e : m_selectedList.getSelectedValues()) {
            deselectElement(e);
        }
        notifyListeners();
        return;
    }
    
    private void addAllElements() {
        selectElements(m_deselectedElements);
        notifyListeners();
        return;
    }
    
    private void deleteAllElements() {
        deselectElements(m_selectedElements);
        notifyListeners();
    }
    
    private void updateButtons() {
        m_addButton.setEnabled(m_deselectedList.getSelectedIndex() != -1);
        m_delButton.setEnabled(m_selectedList.getSelectedIndex() != -1);
        m_addAllButton.setEnabled(m_deselectedList.getModel().getSize() > 0);
        m_delAllButton.setEnabled(m_selectedList.getModel().getSize() > 0);
        
        return;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        m_leftPane = new javax.swing.JPanel();
        m_selectedScrollPane = new javax.swing.JScrollPane();
        m_selectedList = new javax.swing.JList();
        m_rightPane = new javax.swing.JPanel();
        m_buttonsPane = new javax.swing.JPanel();
        m_addButton = new javax.swing.JButton();
        m_addAllButton = new javax.swing.JButton();
        m_delButton = new javax.swing.JButton();
        m_delAllButton = new javax.swing.JButton();
        m_deselectedScrollPane = new javax.swing.JScrollPane();
        m_deselectedList = new javax.swing.JList();

        setLayout(new java.awt.GridLayout(1, 2));

        m_leftPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected"));
        m_leftPane.setLayout(new java.awt.GridBagLayout());

        m_selectedList.setModel(m_selectedElementsListModel);
        m_selectedList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                m_selectedListValueChanged(evt);
            }
        });
        m_selectedScrollPane.setViewportView(m_selectedList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        m_leftPane.add(m_selectedScrollPane, gridBagConstraints);

        add(m_leftPane);

        m_rightPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Deselected"));
        m_rightPane.setLayout(new java.awt.GridBagLayout());

        m_buttonsPane.setLayout(new java.awt.GridBagLayout());

        m_addButton.setText("<");
        m_addButton.setToolTipText("Add to selected");
        m_addButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_addButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_addButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_addButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_addButton, gridBagConstraints);

        m_addAllButton.setText("+");
        m_addAllButton.setToolTipText("Add all to selected");
        m_addAllButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_addAllButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_addAllButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_addAllButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_addAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_addAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_addAllButton, gridBagConstraints);

        m_delButton.setText(">");
        m_delButton.setToolTipText("Remove from selected");
        m_delButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_delButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_delButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_delButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_delButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_delButton, gridBagConstraints);

        m_delAllButton.setText("-");
        m_delAllButton.setToolTipText("Remove all from selected");
        m_delAllButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_delAllButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_delAllButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_delAllButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_delAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_delAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_delAllButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        m_rightPane.add(m_buttonsPane, gridBagConstraints);

        m_deselectedList.setModel(m_deselectedElementsListModel);
        m_deselectedList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                m_deselectedListValueChanged(evt);
            }
        });
        m_deselectedScrollPane.setViewportView(m_deselectedList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        m_rightPane.add(m_deselectedScrollPane, gridBagConstraints);

        add(m_rightPane);
    }// </editor-fold>//GEN-END:initComponents

private void m_addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_addButtonActionPerformed
    addElement();
}//GEN-LAST:event_m_addButtonActionPerformed

private void m_delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_delButtonActionPerformed
    deleteElement();
}//GEN-LAST:event_m_delButtonActionPerformed

private void m_addAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_addAllButtonActionPerformed
    addAllElements();
}//GEN-LAST:event_m_addAllButtonActionPerformed

private void m_delAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_delAllButtonActionPerformed
    deleteAllElements();
}//GEN-LAST:event_m_delAllButtonActionPerformed

private void m_selectedListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_m_selectedListValueChanged
    updateButtons();
}//GEN-LAST:event_m_selectedListValueChanged

private void m_deselectedListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_m_deselectedListValueChanged
    updateButtons();
}//GEN-LAST:event_m_deselectedListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_addAllButton;
    private javax.swing.JButton m_addButton;
    private javax.swing.JPanel m_buttonsPane;
    private javax.swing.JButton m_delAllButton;
    private javax.swing.JButton m_delButton;
    private javax.swing.JList m_deselectedList;
    private javax.swing.JScrollPane m_deselectedScrollPane;
    private javax.swing.JPanel m_leftPane;
    private javax.swing.JPanel m_rightPane;
    private javax.swing.JList m_selectedList;
    private javax.swing.JScrollPane m_selectedScrollPane;
    // End of variables declaration//GEN-END:variables

    java.util.List m_selectedElements;
    java.util.List m_deselectedElements;
    
    java.util.List m_elements;
    
    ElementsListModel m_selectedElementsListModel;
    ElementsListModel m_deselectedElementsListModel;
    
    java.util.List<IElementsChooserListener> m_listeners;
    
    class ElementsListModel extends javax.swing.AbstractListModel {
        
        public void setElements(java.util.List elements) {
            m_elements = elements;
            fireContentsChanged();
            
            return;
        }
        
        public void fireContentsChanged() {
            if(m_elements == null) {
                fireContentsChanged(this, 0, 0);
            }
            else {
                fireContentsChanged(this, 0, m_elements.size());
            }
            
            return;
        }
        
        public Object getElementAt(int index) {
            if(getSize() <= index) {
                return null;
            }
            
            return m_elements.get(index);
        }

        public int getSize() {
            if(m_elements == null) {
                return 0;
            }
            
            return m_elements.size();
        }
        
        java.util.List m_elements;
    }
}
