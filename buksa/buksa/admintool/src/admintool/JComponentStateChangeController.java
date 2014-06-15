package admintool;

public class JComponentStateChangeController {
    
    public static final javax.swing.border.LineBorder CHANGED_BORDER = new javax.swing.border.LineBorder(java.awt.Color.RED);
    
    public JComponentStateChangeController() {
        m_hash = new java.util.Hashtable<javax.swing.JComponent, ComponentInfo>();
        m_componentStateChangeListeners = new java.util.Vector<IComponentStateChangeListener>();
        return;
    }
    
    public void addComponentStateChangeListener(IComponentStateChangeListener listener) {
        if(listener == null) {
            return;
        }
        m_componentStateChangeListeners.add(listener);
        return;
    }
    
    public boolean addComponent(javax.swing.JComponent component) {
        return this.addComponent(component, component);
    }
    
    public boolean addComponent(javax.swing.JComponent component, javax.swing.JComponent view) {
        if(component == null) {
            return false;
        }
        m_hash.put(component, new ComponentInfo(view, false));
        registerChangeListener(component);
        return true;
    }

    public boolean isComponentStateChanged(javax.swing.JComponent component) {
        ComponentInfo ci;
        
        if(component == null) {
            return false;
        }
        
        ci = m_hash.get(component);
        
        if(ci == null) {
            return false;
        }
        
        return ci.stateChanged;
    }

    public boolean isComponentStateChanged() {
        for(javax.swing.JComponent component : m_hash.keySet()) {
            if(isComponentStateChanged(component) == true) {
                return true;
            }
        }
        return false;
    }

    public void setComponentStateChanged(javax.swing.JComponent component, boolean stateChanged) {
        ComponentInfo ci;
        
        if(component == null) {
            return;
        }
        
        ci = m_hash.get(component);
        
        if(ci == null) {
            return;
        }
        
        if(ci.stateChanged == stateChanged) {
            return;
        }
        
        ci.stateChanged = stateChanged;

        if(ci.view != null) {
            if(stateChanged == true) {
                ci.view.setBorder(CHANGED_BORDER);
            }
            else {
                ci.view.setBorder(ci.border);
            }
        }
        
        if(stateChanged == true) {
            notifyComponentChanged(component);
        }
        
        return;
    }
    
    public void setComponentStateChanged(boolean stateChanged) {
        for(javax.swing.JComponent component : m_hash.keySet()) {
            setComponentStateChanged(component, stateChanged);
        }
    }
    
    private void notifyComponentChanged(javax.swing.JComponent component) {
        setComponentStateChanged(component, true);
        for(IComponentStateChangeListener listener : m_componentStateChangeListeners) {
            listener.componentStateChanged(this, component);
        }
        return;
    }
    
    private void registerChangeListener(javax.swing.JComponent component) {
        if(component == null) {
            return;
        }
        
        if(component instanceof javax.swing.JTextField) {
            ((javax.swing.JTextField) component).getDocument().addDocumentListener(new StateChangeDocumentListener(component));
        }
        else if(component instanceof javax.swing.JTextArea) {
            ((javax.swing.JTextArea) component).getDocument().addDocumentListener(new StateChangeDocumentListener(component));
        }
        else if(component instanceof javax.swing.JComboBox) {
            ((javax.swing.JComboBox) component).addActionListener(new StateChangeActionListener(component));
        }
        else if(component instanceof ElementsChooser) {
            ((ElementsChooser) component).addElementChooserListener(new StateChangeElementChooserListener(component));
        }
    }
    
    private class ComponentInfo {
        public ComponentInfo(javax.swing.JComponent view, boolean stateChanged) {
            this.stateChanged = stateChanged;
            this.view = view;
            if(view != null) {
                this.border = view.getBorder();
            }
            else {
                this.border = null;
            }
            return;
        }
        public ComponentInfo(javax.swing.JComponent view) {
            this(view, false);
        }
        public boolean stateChanged;
        public javax.swing.JComponent view;
        public javax.swing.border.Border border;
    }
    
    private class StateChangeDocumentListener implements javax.swing.event.DocumentListener {
        public StateChangeDocumentListener(javax.swing.JComponent component) {
            m_component = component;
        }
        
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            JComponentStateChangeController.this.setComponentStateChanged(m_component, true);
        }

        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            JComponentStateChangeController.this.setComponentStateChanged(m_component, true);
        }

        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            JComponentStateChangeController.this.setComponentStateChanged(m_component, true);
        }
        
        private javax.swing.JComponent m_component;
    }
    
    private class StateChangeActionListener implements java.awt.event.ActionListener {
        public StateChangeActionListener(javax.swing.JComponent component) {
            m_component = component;
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            JComponentStateChangeController.this.setComponentStateChanged(m_component, true);
        }
        
        private javax.swing.JComponent m_component;
    }

    private class StateChangeElementChooserListener implements IElementsChooserListener {
        public StateChangeElementChooserListener(javax.swing.JComponent component) {
            m_component = component;
        }
        public void elementChooserActionPerformed(ElementsChooser chooser) {
            JComponentStateChangeController.this.setComponentStateChanged(m_component, true);
        }
        
        private javax.swing.JComponent m_component;
    }
    
    private java.util.Hashtable<javax.swing.JComponent, ComponentInfo> m_hash;
    
    private java.util.List<IComponentStateChangeListener> m_componentStateChangeListeners;
}
