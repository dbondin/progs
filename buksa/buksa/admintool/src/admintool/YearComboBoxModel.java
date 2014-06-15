/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admintool;

import java.util.Calendar;

/**
 *
 * @author dbondin
 */
public class YearComboBoxModel extends javax.swing.DefaultComboBoxModel {

    public static final String NULL_YEAR_ITEM = "<unknown>";
    public static final int MIN_YEAR = 1900;

    public YearComboBoxModel() {
        super();

        int i;
        addElement(NULL_YEAR_ITEM);
        for(i=MIN_YEAR; i<=Calendar.getInstance().get(Calendar.YEAR); i++) {
           addElement(Integer.valueOf(i));
        }
    }

    @Override
    public void setSelectedItem(Object item) {

        int i;
        Object validItem = NULL_YEAR_ITEM;
        Object listItem;

        if(item instanceof Integer) {
            for(i=0; i<getSize(); i++) {
                listItem = getElementAt(i);
                if(item.equals(listItem)) {
                    validItem = listItem;
                    break;
                }
            }
        }

        super.setSelectedItem(validItem);
    }
}
