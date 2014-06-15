package admintool;

import admintool.entity.BookInfo;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class BookPane extends javax.swing.JPanel
        implements IComponentStateChangeListener {

    public static final int ACTION_EVENT_APPLY = 0;
    public static final int COVER_IMAGE_WIDTH = 128;
    public static final int COVER_IMAGE_HEIGHT = 128;
    public static final java.awt.Dimension COVER_IMAGE_SIZE = new java.awt.Dimension(COVER_IMAGE_WIDTH, COVER_IMAGE_HEIGHT);

    /** Creates new form BookPane */
    public BookPane() {

        m_actionEvent = new java.awt.event.ActionEvent(this, ACTION_EVENT_APPLY, "apply");
        m_actionListenersList = new java.util.Vector<java.awt.event.ActionListener>();
        m_noCoverImageIcon = new javax.swing.ImageIcon(this.getClass().getResource("/admintool/images/nocover.gif"));
        m_formatModel = new FormatComboBoxModel();
        m_yearComboBoxModel = new YearComboBoxModel();

        initComponents();

        m_stateChangeController = new JComponentStateChangeController();

        m_stateChangeController.addComponentStateChangeListener(this);

        m_stateChangeController.addComponent(m_titleTextField);
        m_stateChangeController.addComponent(m_authorsTextField);
        m_stateChangeController.addComponent(m_publisherTextField);
        m_stateChangeController.addComponent(m_descriptionTextArea, m_descriptionScrollPane);
        m_stateChangeController.addComponent(m_formatComboBox);
        m_stateChangeController.addComponent(m_coverImage);
        m_stateChangeController.addComponent(m_tagsChooser);
        m_stateChangeController.addComponent(m_yearComboBox);
        
        m_coverImage.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));

        setData(null, null, null);
        
        setShowButtons(true);
        setShowTimes(true);

        return;
    }

    public void setShowButtons(boolean showButtons) {
        m_showButtons = showButtons;

        m_buttonsPane.setVisible(m_showButtons);
    }

    public void setShowTimes(boolean showTimes) {
        m_showTimes = showTimes;

        m_ctimeLabel.setVisible(m_showTimes);
        m_ctimeText.setVisible(m_showTimes);
        m_mtimeLabel.setVisible(m_showTimes);
        m_mtimeText.setVisible(m_showTimes);
    }

    public boolean isShowButtons() {
        return m_showButtons;
    }

    public boolean isShowTimes() {
        return m_showTimes;
    }

    public void componentStateChanged(JComponentStateChangeController controller, JComponent component) {
        m_undoButton.setEnabled(true);
        m_applyButton.setEnabled(true);
    }

    public void addActionListener(java.awt.event.ActionListener actionListener) {
        m_actionListenersList.add(actionListener);
    }

    public void removeActionListener(java.awt.event.ActionListener actionListener) {
        m_actionListenersList.remove(actionListener);
    }

    protected void fireActionEvent() {
        for (java.awt.event.ActionListener l : m_actionListenersList) {
            l.actionPerformed(m_actionEvent);
        }
    }

    private static java.awt.Dimension getCoverImageSize() {
        return COVER_IMAGE_SIZE;
    }

    private void updateBookInfoObject() {
        if (m_bookInfo == null) {
            return;
        }

        if (m_stateChangeController.isComponentStateChanged(m_titleTextField) == true) {
            m_bookInfo.setTitle(m_titleTextField.getText());
        }

        if (m_stateChangeController.isComponentStateChanged(m_authorsTextField) == true) {
            m_bookInfo.setAuthors(m_authorsTextField.getText());
        }

        if (m_stateChangeController.isComponentStateChanged(m_publisherTextField) == true) {
            m_bookInfo.setPublisher(m_publisherTextField.getText());
        }

        if (m_stateChangeController.isComponentStateChanged(m_descriptionTextArea) == true) {
            m_bookInfo.setDescription(m_descriptionTextArea.getText());
        }

        if (m_stateChangeController.isComponentStateChanged(m_formatComboBox) == true) {
            if (m_formatComboBox.getSelectedItem() == FormatComboBoxModel.NULL_FORMAT_ITEM) {
                m_bookInfo.setFormat(null);
            } else {
                m_bookInfo.setFormat((admintool.entity.FormatTitle) m_formatComboBox.getSelectedItem());
            }
        }

        if (m_stateChangeController.isComponentStateChanged(m_coverImage) == true) {
            ImageIcon ii;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            java.awt.image.BufferedImage bi;
            ii = (ImageIcon) m_coverImage.getIcon();
            bi = new java.awt.image.BufferedImage(ii.getIconWidth(), ii.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.getGraphics();
            g.drawImage(ii.getImage(), 0, 0, this);

            try {
                ImageIO.write(bi, "jpg", out);
            } catch (java.io.IOException ex) {
                //
            }

            m_bookInfo.setCoverImageData(out.toByteArray());
        }
        
        if (m_stateChangeController.isComponentStateChanged(m_tagsChooser) == true) {
            m_bookInfo.setTags(m_tagsChooser.getSelectedElements());
        }
        
        if (m_stateChangeController.isComponentStateChanged(m_yearComboBox) == true) {
            Object value = m_yearComboBox.getSelectedItem();
            if(value == null || value == YearComboBoxModel.NULL_YEAR_ITEM) {
                m_bookInfo.setYear(null);
            }
            else {
                m_bookInfo.setYear((Integer)value);
            }
        }

        return;
    }

    public admintool.entity.BookInfo getBookInfo() {
        updateBookInfoObject();
        return m_bookInfo;
    }

    public void setData(admintool.entity.BookInfo bookInfo,
            java.util.List<admintool.entity.FormatTitle> formatTitles,
            java.util.List<admintool.entity.TagTitle> tagTitles) {
        m_bookInfo = bookInfo;
        m_formatTitleList = formatTitles;
        m_tagTitleList = tagTitles;
        
        updateGUIObjects();

        return;
    }

    private void updateGUIObjects() {

        m_formatModel.setItems(m_formatTitleList);
        m_tagsChooser.setElements(m_tagTitleList, (m_bookInfo != null && m_bookInfo.getTags() != null) ? new java.util.Vector(m_bookInfo.getTags()) : null);

        if (m_bookInfo == null) {
            m_titleTextField.setText(null);
            m_ctimeText.setText(null);
            m_mtimeText.setText(null);
            m_filenameText.setText(null);
            m_authorsTextField.setText(null);
            m_publisherTextField.setText(null);
            m_descriptionTextArea.setText(null);
            m_formatComboBox.setSelectedItem(null);
            m_yearComboBox.setSelectedItem(null);
        } else {
            m_titleTextField.setText(m_bookInfo.getTitle());
            m_ctimeText.setText((m_bookInfo.getCTime() != null) ? dateFormat.format(m_bookInfo.getCTime()) : null);
            m_mtimeText.setText((m_bookInfo.getMTime() != null) ? dateFormat.format(m_bookInfo.getMTime()) : null);
            m_filenameText.setText(m_bookInfo.getFilename());
            m_authorsTextField.setText(m_bookInfo.getAuthors());
            m_publisherTextField.setText(m_bookInfo.getPublisher());
            m_descriptionTextArea.setText(m_bookInfo.getDescription());
            m_formatComboBox.setSelectedItem(m_bookInfo.getFormat());
            m_yearComboBox.setSelectedItem(m_bookInfo.getYear());
        }

        m_coverImage.setIcon(getCoverImageIcon());

        m_stateChangeController.setComponentStateChanged(false);

        m_undoButton.setEnabled(false);
        m_applyButton.setEnabled(false);

        return;
    }

    private java.awt.Image getImageScaledToCoverSize(java.awt.Image img) {
        int iw;
        int ih;
        double sw;
        double sh;

        javax.swing.ImageIcon ii = new javax.swing.ImageIcon(img);

        iw = ii.getIconWidth();
        ih = ii.getIconHeight();

        sw = 1.0 * COVER_IMAGE_WIDTH / iw;
        sh = 1.0 * COVER_IMAGE_HEIGHT / ih;

        if (sw < sh) {
            sh = sw;
        } else {
            sw = sh;
        }

        iw = (int) (sw * iw);
        ih = (int) (sh * ih);

        return ii.getImage().getScaledInstance(iw, ih, java.awt.Image.SCALE_FAST);
    }

    private javax.swing.Icon getCoverImageIcon() {
        javax.swing.ImageIcon ii;

        if (m_bookInfo == null ||
                m_bookInfo.getCoverImageData() == null) {
            ii = m_noCoverImageIcon;
        } else {
            ii = new javax.swing.ImageIcon(m_bookInfo.getCoverImageData());

            if (ii.getIconHeight() <= 0 || ii.getIconWidth() <= 0) {
                ii = m_noCoverImageIcon;
            }
        }

        if (ii == m_noCoverImageIcon) {
            return ii;
        }

        return new javax.swing.ImageIcon(getImageScaledToCoverSize(ii.getImage()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        m_fileChooser = new javax.swing.JFileChooser();
        m_coverImageMenu = new javax.swing.JPopupMenu();
        m_coverImageMenuDelItem = new javax.swing.JMenuItem();
        m_titleLabel = new javax.swing.JLabel();
        m_ctimeLabel = new javax.swing.JLabel();
        m_mtimeLabel = new javax.swing.JLabel();
        m_coverLabel = new javax.swing.JLabel();
        m_titleTextField = new javax.swing.JTextField();
        m_ctimeText = new javax.swing.JLabel();
        m_mtimeText = new javax.swing.JLabel();
        m_dummyComponent = new javax.swing.JPanel();
        m_coverImage = new javax.swing.JLabel();
        m_filenameLabel = new javax.swing.JLabel();
        m_filenameText = new javax.swing.JLabel();
        m_authorsLabel = new javax.swing.JLabel();
        m_authorsTextField = new javax.swing.JTextField();
        m_publisherLabel = new javax.swing.JLabel();
        m_publisherTextField = new javax.swing.JTextField();
        m_descriptionLabel = new javax.swing.JLabel();
        m_descriptionScrollPane = new javax.swing.JScrollPane();
        m_descriptionTextArea = new javax.swing.JTextArea();
        m_buttonsPane = new javax.swing.JPanel();
        m_undoButton = new javax.swing.JButton();
        m_applyButton = new javax.swing.JButton();
        m_formatLabel = new javax.swing.JLabel();
        m_formatComboBox = new javax.swing.JComboBox();
        m_tagsLabel = new javax.swing.JLabel();
        m_tagsChooser = new admintool.ElementsChooser();
        m_yearLabel = new javax.swing.JLabel();
        m_yearComboBox = new javax.swing.JComboBox();

        m_fileChooser.setDialogTitle("Выбор обложки");
        m_fileChooser.setFileFilter(m_fileFilter);

        m_coverImageMenuDelItem.setText("Delete cover");
        m_coverImageMenuDelItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_coverImageMenuDelItemActionPerformed(evt);
            }
        });
        m_coverImageMenu.add(m_coverImageMenuDelItem);

        setMinimumSize(new java.awt.Dimension(320, 200));
        setPreferredSize(new java.awt.Dimension(320, 200));
        setLayout(new java.awt.GridBagLayout());

        m_titleLabel.setText("Название:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_titleLabel, gridBagConstraints);

        m_ctimeLabel.setText("Дата добавления:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_ctimeLabel, gridBagConstraints);

        m_mtimeLabel.setText("Дата модификации:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_mtimeLabel, gridBagConstraints);

        m_coverLabel.setText("Обложка:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_coverLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_titleTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_ctimeText, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_mtimeText, gridBagConstraints);

        javax.swing.GroupLayout m_dummyComponentLayout = new javax.swing.GroupLayout(m_dummyComponent);
        m_dummyComponent.setLayout(m_dummyComponentLayout);
        m_dummyComponentLayout.setHorizontalGroup(
            m_dummyComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        m_dummyComponentLayout.setVerticalGroup(
            m_dummyComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(m_dummyComponent, gridBagConstraints);

        m_coverImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        m_coverImage.setIcon(m_noCoverImageIcon);
        m_coverImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        m_coverImage.setMaximumSize(getCoverImageSize());
        m_coverImage.setMinimumSize(getCoverImageSize());
        m_coverImage.setPreferredSize(getCoverImageSize());
        m_coverImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_coverImageMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_coverImage, gridBagConstraints);

        m_filenameLabel.setText("Имя файла:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_filenameLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_filenameText, gridBagConstraints);

        m_authorsLabel.setText("Автор(ы):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_authorsLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_authorsTextField, gridBagConstraints);

        m_publisherLabel.setText("Издательство:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_publisherLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_publisherTextField, gridBagConstraints);

        m_descriptionLabel.setText("Описание:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_descriptionLabel, gridBagConstraints);

        m_descriptionTextArea.setColumns(20);
        m_descriptionTextArea.setFont(new java.awt.Font("Tahoma", 0, 11));
        m_descriptionTextArea.setRows(5);
        m_descriptionScrollPane.setViewportView(m_descriptionTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_descriptionScrollPane, gridBagConstraints);

        m_buttonsPane.setLayout(new java.awt.GridBagLayout());

        m_undoButton.setText("Отменить изменения");
        m_undoButton.setEnabled(false);
        m_undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_undoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_undoButton, gridBagConstraints);

        m_applyButton.setText("Применить изменения");
        m_applyButton.setEnabled(false);
        m_applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_applyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_buttonsPane.add(m_applyButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(m_buttonsPane, gridBagConstraints);

        m_formatLabel.setText("Формат:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_formatLabel, gridBagConstraints);

        m_formatComboBox.setModel(m_formatModel);
        m_formatComboBox.setMinimumSize(new java.awt.Dimension(128, 24));
        m_formatComboBox.setPreferredSize(new java.awt.Dimension(128, 24));
        m_formatComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_formatComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_formatComboBox, gridBagConstraints);

        m_tagsLabel.setText("Теги:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_tagsLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_tagsChooser, gridBagConstraints);

        m_yearLabel.setText("Год:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_yearLabel, gridBagConstraints);

        m_yearComboBox.setModel(m_yearComboBoxModel);
        m_yearComboBox.setMinimumSize(new java.awt.Dimension(128, 24));
        m_yearComboBox.setPreferredSize(new java.awt.Dimension(128, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(m_yearComboBox, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

private void m_undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_undoButtonActionPerformed
    undoChanges();
}//GEN-LAST:event_m_undoButtonActionPerformed

private void m_coverImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_coverImageMouseClicked
    if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
        selectCoverImage();
    } else if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
        if (m_coverImage.getIcon() != m_noCoverImageIcon) {
            m_coverImageMenu.show(m_coverImage, evt.getX(), evt.getY());
        }
    }
    return;
}//GEN-LAST:event_m_coverImageMouseClicked

    private void clearCoverImage() {
        m_coverImage.setIcon(m_noCoverImageIcon);
        m_stateChangeController.setComponentStateChanged(m_coverImage, true);
        return;
    }

private void m_coverImageMenuDelItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_coverImageMenuDelItemActionPerformed
    clearCoverImage();
}//GEN-LAST:event_m_coverImageMenuDelItemActionPerformed

private void m_applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_applyButtonActionPerformed
    fireActionEvent();
}//GEN-LAST:event_m_applyButtonActionPerformed

private void m_formatComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_formatComboBoxActionPerformed
}//GEN-LAST:event_m_formatComboBoxActionPerformed

    private void selectCoverImage() {

        java.io.File file;
        java.awt.Image img;

        if (m_fileChooser.showOpenDialog(this) != javax.swing.JFileChooser.APPROVE_OPTION) {
            return;
        }

        file = m_fileChooser.getSelectedFile();

        img = java.awt.Toolkit.getDefaultToolkit().createImage(file.getPath());

        m_coverImage.setIcon(new javax.swing.ImageIcon(getImageScaledToCoverSize(img)));

        m_stateChangeController.setComponentStateChanged(m_coverImage, true);

        return;
    }

    private void undoChanges() {
        setData(m_bookInfo, m_formatTitleList, m_tagTitleList);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_applyButton;
    private javax.swing.JLabel m_authorsLabel;
    private javax.swing.JTextField m_authorsTextField;
    private javax.swing.JPanel m_buttonsPane;
    private javax.swing.JLabel m_coverImage;
    private javax.swing.JPopupMenu m_coverImageMenu;
    private javax.swing.JMenuItem m_coverImageMenuDelItem;
    private javax.swing.JLabel m_coverLabel;
    private javax.swing.JLabel m_ctimeLabel;
    private javax.swing.JLabel m_ctimeText;
    private javax.swing.JLabel m_descriptionLabel;
    private javax.swing.JScrollPane m_descriptionScrollPane;
    private javax.swing.JTextArea m_descriptionTextArea;
    private javax.swing.JPanel m_dummyComponent;
    private javax.swing.JFileChooser m_fileChooser;
    private javax.swing.JLabel m_filenameLabel;
    private javax.swing.JLabel m_filenameText;
    private javax.swing.JComboBox m_formatComboBox;
    private javax.swing.JLabel m_formatLabel;
    private javax.swing.JLabel m_mtimeLabel;
    private javax.swing.JLabel m_mtimeText;
    private javax.swing.JLabel m_publisherLabel;
    private javax.swing.JTextField m_publisherTextField;
    private admintool.ElementsChooser m_tagsChooser;
    private javax.swing.JLabel m_tagsLabel;
    private javax.swing.JLabel m_titleLabel;
    private javax.swing.JTextField m_titleTextField;
    private javax.swing.JButton m_undoButton;
    private javax.swing.JComboBox m_yearComboBox;
    private javax.swing.JLabel m_yearLabel;
    // End of variables declaration//GEN-END:variables
    private admintool.entity.BookInfo m_bookInfo;
    private javax.swing.ImageIcon m_noCoverImageIcon;
    private java.util.List<java.awt.event.ActionListener> m_actionListenersList;
    private java.awt.event.ActionEvent m_actionEvent;
    private java.util.List<admintool.entity.FormatTitle> m_formatTitleList;
    private FormatComboBoxModel m_formatModel;
    private java.util.List<admintool.entity.TagTitle> m_tagTitleList;
    private boolean m_showButtons;
    private boolean m_showTimes;
    private JComponentStateChangeController m_stateChangeController;
    private DefaultComboBoxModel m_yearComboBoxModel;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private javax.swing.filechooser.FileFilter m_fileFilter = new javax.swing.filechooser.FileFilter() {

        @Override
        public boolean accept(java.io.File f) {
            String fname;

            if (f.isDirectory()) {
                return true;
            }

            fname = f.getName().toLowerCase();

            if (fname.endsWith(".gif") ||
                    fname.endsWith(".jpg") ||
                    fname.endsWith(".jpeg")) {
                return true;
            }

            return false;
        }

        @Override
        public String getDescription() {
            return "GIF and JPEG files";
        }
    };
    
}
