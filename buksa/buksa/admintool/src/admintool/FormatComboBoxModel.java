package admintool;

public class FormatComboBoxModel extends javax.swing.DefaultComboBoxModel {
    
    public static final String NULL_FORMAT_ITEM = "<unknown>";
    
    public FormatComboBoxModel() {
        super();
        setItems(null);
    }

    @Override
    public void setSelectedItem(Object item) {
        admintool.entity.FormatTitle formatTitle;
        if(item == null ||
           item == NULL_FORMAT_ITEM) {
            super.setSelectedItem(NULL_FORMAT_ITEM);
            return;
        }
        if(! (item instanceof admintool.entity.FormatTitle)) {
            super.setSelectedItem(NULL_FORMAT_ITEM);
            return;            
        }
        
        super.setSelectedItem(item);
    }
    
    public void setItems(java.util.List<admintool.entity.FormatTitle> items) {
        removeAllElements();
        addElement(NULL_FORMAT_ITEM);
        if(items == null) {
            return;
        }
        for(admintool.entity.FormatTitle f : items) {
            addElement(f);
        }
        setSelectedItem(NULL_FORMAT_ITEM);
        return;
    }
}
