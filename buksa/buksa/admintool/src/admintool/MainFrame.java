package admintool;

import admintool.entity.BookInfo;
import admintool.entity.BookTitle;
import admintool.entity.FormatTitle;
import admintool.entity.TagTitle;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class MainFrame extends javax.swing.JFrame {
    public MainFrame() {
        m_addBookDialog = new AddBookDialog(this);
        m_addFormatDialog = new AddFormatDialog(this);
        m_addTagDialog = new AddTagDialog(this);
        m_booksListModel = new BooksListModel();
        m_formatsListModel = new FormatsListModel();
        m_tagsListModel = new TagsListModel();
        initComponents();
        setSize(800, 600);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    private void updateBook() {
        BookInfo bi;
        
        bi = m_bookInfoPane.getBookInfo();
        
        setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
        
        try {
            DataBase.getInstance().updateBookInfo(bi);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Error updating database", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            setCursor(java.awt.Cursor.getDefaultCursor());
        }

        refreshData();
        
        return;
    }
    
    private void updateFormat() {
        admintool.entity.Format f;
        
        f = m_formatPane.getFormat();
        
        setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
        
        try {
            DataBase.getInstance().updateFormat(f);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Error updating database", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            setCursor(java.awt.Cursor.getDefaultCursor());
        }

        refreshData();
        
        return;
    }
    
    private void updateTag() {
        admintool.entity.Tag t;
        
        t = m_tagPane.getTag();
        
        setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
        
        try {
            DataBase.getInstance().updateTag(t);
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Error updating database", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            setCursor(java.awt.Cursor.getDefaultCursor());
        }

        refreshData();
        
        return;
    }
    
    private void deleteBook() {
        admintool.entity.BookTitle bookTitle;
    
        bookTitle = (admintool.entity.BookTitle) m_booksList.getSelectedValue();
        
        if(bookTitle == null) {
            return;
        }
        
        if(JOptionPane.showConfirmDialog(this, "Really delete book?", "Delete confirmation", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        
        if(DataBase.getInstance().deleteBook(bookTitle.getId()) != true) {
            JOptionPane.showMessageDialog(this, "Error deleting book");
        }
        
        refreshData();
        
        JOptionPane.showMessageDialog(this, "Book deleted");
        
        return;
    }
    
    private void deleteFormat() {
        admintool.entity.FormatTitle ft;
    
        ft = (admintool.entity.FormatTitle) m_formatsList.getSelectedValue();
        
        if(ft == null) {
            return;
        }
        
        if(JOptionPane.showConfirmDialog(this, "Really delete format?", "Delete confirmation", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        
        if(DataBase.getInstance().deleteFormat(ft.getId()) != true) {
            JOptionPane.showMessageDialog(this, "Error deleting format");
        }
        
        refreshData();
        
        JOptionPane.showMessageDialog(this, "Format deleted");
        
        return;
    }
    
    private void deleteTag() {
        admintool.entity.TagTitle tt;
    
        tt = (admintool.entity.TagTitle) m_tagsList.getSelectedValue();
        
        if(tt == null) {
            return;
        }
        
        if(JOptionPane.showConfirmDialog(this, "Really delete tag?", "Delete confirmation", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        
        if(DataBase.getInstance().deleteTag(tt.getId()) != true) {
            JOptionPane.showMessageDialog(this, "Error deleting tag");
        }
        
        refreshData();
        
        JOptionPane.showMessageDialog(this, "Tag deleted");
        
        return;
    }
    
    private void viewFormat() {
        admintool.entity.FormatTitle formatTitle;
    
        formatTitle = (admintool.entity.FormatTitle) m_formatsList.getSelectedValue();

        setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
    
        if(formatTitle != null) {
            m_formatPane.setFormat(DataBase.getInstance().getFormat(formatTitle.getId()));
        }
        else {
            m_formatPane.setFormat(null);
        }
    
        setCursor(java.awt.Cursor.getDefaultCursor());
    
        return;
    }
    
    private void viewBook() {
        admintool.entity.BookTitle bookTitle;
    
        bookTitle = (admintool.entity.BookTitle) m_booksList.getSelectedValue();

        setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
    
        if(bookTitle != null) {
            DataBase.BookInfoAndFormatTitles data = DataBase.getInstance().getBookInfoAndFormatTitles(bookTitle.getId());
            if(data != null) {
                m_bookInfoPane.setData(data.bookInfo,
                                       data.formatTitles,
                                       data.tagTitles);
            }
            else {
                m_bookInfoPane.setData(null, null, null);
            }
        }
        else {
            m_bookInfoPane.setData(null, null, null);
        }
    
        setCursor(java.awt.Cursor.getDefaultCursor());
    
        return;
    }
    
    private String createFileNameString(admintool.entity.BookInfo bi, admintool.entity.Format f) {
        String result;
        
        result = new String();
        
        if(bi != null) {
            result += bi.getTitle();
            if(bi.getAuthors() != null) {
                result += " (" + bi.getAuthors() + ").";
            }
            else {
                result += ".";
            }
            if(f != null && f.getExtension() != null) {
                result += f.getExtension();
            }
            else {
                if(bi.getFilename() != null && bi.getFilename().lastIndexOf(".") != -1) {
                    result += bi.getFilename().substring(bi.getFilename().lastIndexOf(".") + 1);
                }
                else {
                    result += "book";
                }
            }
        }
        
        return result;
    }
    
    private void getBook() {
        admintool.entity.BookTitle bt;
        DataBase.BookInfoAndFormat biaf;
        String filename;
        java.io.File file;
        java.io.FileOutputStream fos;
        
        bt = (admintool.entity.BookTitle) m_booksList.getSelectedValue();
        
        if(bt == null) {
            return;
        }
        
        biaf = DataBase.getInstance().getBookInfoAndFormat(bt.getId());
        
        if(biaf == null) {
            return;
        }
        
        if(biaf.bookInfo == null) {
            return;
        }
        
        m_getBookFileChooser.setSelectedFile(new java.io.File(createFileNameString(biaf.bookInfo, biaf.format)));
        
        if(m_getBookFileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        file = m_getBookFileChooser.getSelectedFile();
        
        if(file == null) {
            return;
        }
    
        try {
            fos = new java.io.FileOutputStream(file);
        }
        catch (java.io.FileNotFoundException ex) {
            return;
        }

        if(DataBase.getInstance().saveBookDataStream(bt.getId(), fos) != true) {
            JOptionPane.showMessageDialog(this, "Error saving file");
            return;
        }
        
        try {
            fos.close();
        }
        catch(java.io.IOException ex) {
            return;
        }
        
        JOptionPane.showMessageDialog(this, "File saved");
        
        return;
    }
    
    private void addFormat() {
        admintool.entity.Format f;
        
        f = m_addFormatDialog.showDialog();
        
        if(f == null)
        {
            return;
        }
        
        if(DataBase.getInstance().addFormat(f) != true) {
            JOptionPane.showMessageDialog(this, "Error adding format");
            return;
        }
        
        refreshData();
        
        JOptionPane.showMessageDialog(this, "Format added");
        
        return;
    }
    
    private void addTag() {
        admintool.entity.Tag t;
        
        t = m_addTagDialog.showDialog();
        
        if(t == null)
        {
            return;
        }
        
        if(DataBase.getInstance().addTag(t) != true) {
            JOptionPane.showMessageDialog(this, "Error adding tag");
            return;
        }
        
        refreshData();
        
        JOptionPane.showMessageDialog(this, "Tag added");
        
        return;
    }
    
    private void addBook() {
        int status;
        java.io.File selectedFile;
        admintool.entity.BookInfo bi;
        final admintool.entity.Book bk;
        StatefullFileInputStream fis;
        
        status = m_addBookFileChooser.showOpenDialog(this);
        
        if(status != javax.swing.JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        selectedFile = m_addBookFileChooser.getSelectedFile();
        
        if(!selectedFile.isFile()) {
            return;
        }

        try {
            fis = new StatefullFileInputStream(selectedFile);
        } catch(java.io.IOException ex) {
            JOptionPane.showMessageDialog(this, "Can't open file");
            return;
        }
        
        fis.addStatefullFileInputStreamListener(new IStatefullFileInputStreamListener() {

            @Override
            public void statefullFileInputStreamRead(StatefullFileInputStream stream, long offset, long fileSize) {
                int progress = 0;
                if(fileSize != 0 && offset <= fileSize) {
                    progress = (int) (100.0 * offset / fileSize);
                }
                MainFrame.this.m_booksProgressBar.setValue(progress);
            }

            @Override
            public void statefullFileInputStreamClose(StatefullFileInputStream stream) {
                MainFrame.this.m_booksProgressBar.setValue(100);
            }
        });
        
        bi = m_addBookDialog.showDialog(selectedFile);
        
        if(bi == null) {
            return;
        }
        
        bk = new admintool.entity.Book(bi);
        bk.setBinData(DataBase.getInstance().createBlob(fis));

        /* Thread */
        SwingWorker task = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                DataBase.getInstance().addBook(bk);
                return null;
            }

            @Override
            protected void done() {
                MainFrame.this.setCursor(Cursor.getDefaultCursor());
                MainFrame.this.setEnabled(true);
                MainFrame.this.refreshData();
                JOptionPane.showMessageDialog(MainFrame.this, "Book added");
                MainFrame.this.m_booksProgressBar.setValue(0);
            }


        };

        /* Set wait cursor & enabled state */
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        setEnabled(false);

        /* Run the book add thread */
        task.execute();

        return;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        m_addBookFileChooser = new javax.swing.JFileChooser();
        m_getBookFileChooser = new javax.swing.JFileChooser();
        m_tabbedPane = new javax.swing.JTabbedPane();
        m_booksTabPane = new javax.swing.JPanel();
        m_booksSplitPane = new javax.swing.JSplitPane();
        m_booksPane = new javax.swing.JPanel();
        m_booksButtonsPane = new javax.swing.JPanel();
        m_bookAddButton = new javax.swing.JButton();
        m_bookDelButton = new javax.swing.JButton();
        m_bookGetButton = new javax.swing.JButton();
        m_booksCountLabel = new javax.swing.JLabel();
        m_booksScrollPane = new javax.swing.JScrollPane();
        m_booksList = new javax.swing.JList();
        m_booksProgressBar = new javax.swing.JProgressBar();
        m_bookInfoPane = new admintool.BookPane();
        m_formatsTabPane = new javax.swing.JPanel();
        m_formatsSplitPane = new javax.swing.JSplitPane();
        m_formatsPane = new javax.swing.JPanel();
        m_formatsButtonsPane = new javax.swing.JPanel();
        m_formatsAddButton = new javax.swing.JButton();
        m_formatsDelButton = new javax.swing.JButton();
        m_formatsScrollPane = new javax.swing.JScrollPane();
        m_formatsList = new javax.swing.JList();
        m_formatPane = new admintool.FormatPane();
        m_tagsTabPane = new javax.swing.JPanel();
        m_tagsSplitPane = new javax.swing.JSplitPane();
        m_tagsPane = new javax.swing.JPanel();
        m_tagsButtonsPane = new javax.swing.JPanel();
        m_tagsAddButton = new javax.swing.JButton();
        m_tagsDelButton = new javax.swing.JButton();
        m_tagsScrollPane = new javax.swing.JScrollPane();
        m_tagsList = new javax.swing.JList();
        m_tagPane = new admintool.TagPane();
        m_mainMenuBar = new javax.swing.JMenuBar();
        m_fileMenu = new javax.swing.JMenu();
        m_fileMenuRefreshItem = new javax.swing.JMenuItem();
        m_fileMenuExitItemSeparator = new javax.swing.JSeparator();
        m_fileMenuExitItem = new javax.swing.JMenuItem();

        m_getBookFileChooser.setDialogTitle("Сохранить книгу как ...");
        m_getBookFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booksa AdminTool");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        m_booksTabPane.setLayout(new java.awt.GridBagLayout());

        m_booksSplitPane.setDividerLocation(256);
        m_booksSplitPane.setDividerSize(4);

        m_booksPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Книги"));
        m_booksPane.setLayout(new java.awt.GridBagLayout());

        m_booksButtonsPane.setLayout(new java.awt.GridBagLayout());

        m_bookAddButton.setText("+");
        m_bookAddButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_bookAddButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_bookAddButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_bookAddButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_bookAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_bookAddButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_booksButtonsPane.add(m_bookAddButton, gridBagConstraints);

        m_bookDelButton.setText("-");
        m_bookDelButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_bookDelButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_bookDelButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_bookDelButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_bookDelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_bookDelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_booksButtonsPane.add(m_bookDelButton, gridBagConstraints);

        m_bookGetButton.setText("[]");
        m_bookGetButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_bookGetButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_bookGetButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_bookGetButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_bookGetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_bookGetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_booksButtonsPane.add(m_bookGetButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_booksButtonsPane.add(m_booksCountLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_booksPane.add(m_booksButtonsPane, gridBagConstraints);

        m_booksList.setModel(getBooksListModel());
        m_booksList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        m_booksList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                m_booksListValueChanged(evt);
            }
        });
        m_booksList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                m_booksListFocusGained(evt);
            }
        });
        m_booksScrollPane.setViewportView(m_booksList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_booksPane.add(m_booksScrollPane, gridBagConstraints);

        m_booksProgressBar.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_booksPane.add(m_booksProgressBar, gridBagConstraints);

        m_booksSplitPane.setLeftComponent(m_booksPane);

        m_bookInfoPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_bookInfoPaneActionPerformed(evt);
            }
        });
        m_booksSplitPane.setRightComponent(m_bookInfoPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        m_booksTabPane.add(m_booksSplitPane, gridBagConstraints);

        m_tabbedPane.addTab("Книги", m_booksTabPane);

        m_formatsTabPane.setLayout(new java.awt.GridBagLayout());

        m_formatsSplitPane.setDividerLocation(256);
        m_formatsSplitPane.setDividerSize(4);

        m_formatsPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Форматы"));
        m_formatsPane.setLayout(new java.awt.GridBagLayout());

        m_formatsButtonsPane.setLayout(new java.awt.GridBagLayout());

        m_formatsAddButton.setText("+");
        m_formatsAddButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_formatsAddButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_formatsAddButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_formatsAddButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_formatsAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_formatsAddButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_formatsButtonsPane.add(m_formatsAddButton, gridBagConstraints);

        m_formatsDelButton.setText("-");
        m_formatsDelButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_formatsDelButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_formatsDelButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_formatsDelButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_formatsDelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_formatsDelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_formatsButtonsPane.add(m_formatsDelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_formatsPane.add(m_formatsButtonsPane, gridBagConstraints);

        m_formatsList.setModel(getFormatsListModel());
        m_formatsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        m_formatsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                m_formatsListValueChanged(evt);
            }
        });
        m_formatsScrollPane.setViewportView(m_formatsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_formatsPane.add(m_formatsScrollPane, gridBagConstraints);

        m_formatsSplitPane.setLeftComponent(m_formatsPane);

        m_formatPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_formatPaneActionPerformed(evt);
            }
        });
        m_formatsSplitPane.setRightComponent(m_formatPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        m_formatsTabPane.add(m_formatsSplitPane, gridBagConstraints);

        m_tabbedPane.addTab("Форматы", m_formatsTabPane);

        m_tagsTabPane.setLayout(new java.awt.GridBagLayout());

        m_tagsSplitPane.setDividerLocation(256);
        m_tagsSplitPane.setDividerSize(4);

        m_tagsPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Тэги"));
        m_tagsPane.setLayout(new java.awt.GridBagLayout());

        m_tagsButtonsPane.setLayout(new java.awt.GridBagLayout());

        m_tagsAddButton.setText("+");
        m_tagsAddButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_tagsAddButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_tagsAddButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_tagsAddButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_tagsAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_tagsAddButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_tagsButtonsPane.add(m_tagsAddButton, gridBagConstraints);

        m_tagsDelButton.setText("-");
        m_tagsDelButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        m_tagsDelButton.setMaximumSize(new java.awt.Dimension(24, 24));
        m_tagsDelButton.setMinimumSize(new java.awt.Dimension(24, 24));
        m_tagsDelButton.setPreferredSize(new java.awt.Dimension(24, 24));
        m_tagsDelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_tagsDelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_tagsButtonsPane.add(m_tagsDelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_tagsPane.add(m_tagsButtonsPane, gridBagConstraints);

        m_tagsList.setModel(getTagsListModel());
        m_tagsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        m_tagsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                m_tagsListValueChanged(evt);
            }
        });
        m_tagsScrollPane.setViewportView(m_tagsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        m_tagsPane.add(m_tagsScrollPane, gridBagConstraints);

        m_tagsSplitPane.setLeftComponent(m_tagsPane);

        m_tagPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_tagPaneActionPerformed(evt);
            }
        });
        m_tagsSplitPane.setRightComponent(m_tagPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        m_tagsTabPane.add(m_tagsSplitPane, gridBagConstraints);

        m_tabbedPane.addTab("Тэги", m_tagsTabPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(m_tabbedPane, gridBagConstraints);

        m_fileMenu.setText("Файл");

        m_fileMenuRefreshItem.setText("Обновить");
        m_fileMenuRefreshItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_fileMenuRefreshItemActionPerformed(evt);
            }
        });
        m_fileMenu.add(m_fileMenuRefreshItem);
        m_fileMenu.add(m_fileMenuExitItemSeparator);

        m_fileMenuExitItem.setText("Выход");
        m_fileMenuExitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_fileMenuExitItemActionPerformed(evt);
            }
        });
        m_fileMenu.add(m_fileMenuExitItem);

        m_mainMenuBar.add(m_fileMenu);

        setJMenuBar(m_mainMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void m_bookAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_bookAddButtonActionPerformed
    addBook();
}//GEN-LAST:event_m_bookAddButtonActionPerformed

private void m_formatsAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_formatsAddButtonActionPerformed
    addFormat();
}//GEN-LAST:event_m_formatsAddButtonActionPerformed

private void m_fileMenuExitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_fileMenuExitItemActionPerformed
    this.dispose();
}//GEN-LAST:event_m_fileMenuExitItemActionPerformed

private void m_tagsAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_tagsAddButtonActionPerformed
    addTag();
}//GEN-LAST:event_m_tagsAddButtonActionPerformed

private void m_booksListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_m_booksListValueChanged
    viewBook();
    return;
}//GEN-LAST:event_m_booksListValueChanged

private void m_bookDelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_bookDelButtonActionPerformed
    deleteBook();
}//GEN-LAST:event_m_bookDelButtonActionPerformed

private void m_booksListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_m_booksListFocusGained
}//GEN-LAST:event_m_booksListFocusGained

private void m_formatsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_m_formatsListValueChanged
    viewFormat();
}//GEN-LAST:event_m_formatsListValueChanged

private void m_bookGetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_bookGetButtonActionPerformed
    getBook();
}//GEN-LAST:event_m_bookGetButtonActionPerformed

private void m_bookInfoPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_bookInfoPaneActionPerformed
    updateBook();
}//GEN-LAST:event_m_bookInfoPaneActionPerformed

private void m_formatPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_formatPaneActionPerformed
    updateFormat();
}//GEN-LAST:event_m_formatPaneActionPerformed

private void m_formatsDelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_formatsDelButtonActionPerformed
    deleteFormat();
}//GEN-LAST:event_m_formatsDelButtonActionPerformed

private void m_tagsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_m_tagsListValueChanged
    viewTag();
}//GEN-LAST:event_m_tagsListValueChanged

private void m_tagPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_tagPaneActionPerformed
    updateTag();
}//GEN-LAST:event_m_tagPaneActionPerformed

private void m_tagsDelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_tagsDelButtonActionPerformed
    deleteTag();
}//GEN-LAST:event_m_tagsDelButtonActionPerformed

private void m_fileMenuRefreshItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_fileMenuRefreshItemActionPerformed
    refreshData();
}//GEN-LAST:event_m_fileMenuRefreshItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser m_addBookFileChooser;
    private javax.swing.JButton m_bookAddButton;
    private javax.swing.JButton m_bookDelButton;
    private javax.swing.JButton m_bookGetButton;
    private admintool.BookPane m_bookInfoPane;
    private javax.swing.JPanel m_booksButtonsPane;
    private javax.swing.JLabel m_booksCountLabel;
    private javax.swing.JList m_booksList;
    private javax.swing.JPanel m_booksPane;
    private javax.swing.JProgressBar m_booksProgressBar;
    private javax.swing.JScrollPane m_booksScrollPane;
    private javax.swing.JSplitPane m_booksSplitPane;
    private javax.swing.JPanel m_booksTabPane;
    private javax.swing.JMenu m_fileMenu;
    private javax.swing.JMenuItem m_fileMenuExitItem;
    private javax.swing.JSeparator m_fileMenuExitItemSeparator;
    private javax.swing.JMenuItem m_fileMenuRefreshItem;
    private admintool.FormatPane m_formatPane;
    private javax.swing.JButton m_formatsAddButton;
    private javax.swing.JPanel m_formatsButtonsPane;
    private javax.swing.JButton m_formatsDelButton;
    private javax.swing.JList m_formatsList;
    private javax.swing.JPanel m_formatsPane;
    private javax.swing.JScrollPane m_formatsScrollPane;
    private javax.swing.JSplitPane m_formatsSplitPane;
    private javax.swing.JPanel m_formatsTabPane;
    private javax.swing.JFileChooser m_getBookFileChooser;
    private javax.swing.JMenuBar m_mainMenuBar;
    private javax.swing.JTabbedPane m_tabbedPane;
    private admintool.TagPane m_tagPane;
    private javax.swing.JButton m_tagsAddButton;
    private javax.swing.JPanel m_tagsButtonsPane;
    private javax.swing.JButton m_tagsDelButton;
    private javax.swing.JList m_tagsList;
    private javax.swing.JPanel m_tagsPane;
    private javax.swing.JScrollPane m_tagsScrollPane;
    private javax.swing.JSplitPane m_tagsSplitPane;
    private javax.swing.JPanel m_tagsTabPane;
    // End of variables declaration//GEN-END:variables

    private javax.swing.ListModel getBooksListModel() {
        return m_booksListModel;
    }
    
    private javax.swing.ListModel getFormatsListModel() {
        return m_formatsListModel;
    }
    
    private javax.swing.ListModel getTagsListModel() {
        return m_tagsListModel;
    }
    
    private void refreshData() {
        BookTitle bt;
        FormatTitle ft;
        TagTitle tt;
        
        bt = (BookTitle) m_booksList.getSelectedValue();
        ft = (FormatTitle) m_formatsList.getSelectedValue();
        tt = (TagTitle) m_tagsList.getSelectedValue();
        
        m_booksList.clearSelection();
        m_formatsList.clearSelection();
        m_tagsList.clearSelection();
        
        m_bookTitles = DataBase.getInstance().getAllBookTitles();
        m_booksListModel.fireContentChanged();
        
        m_formatTitles = DataBase.getInstance().getAllFormatTitles();
        m_formatsListModel.fireContentChanged();
        
        m_tagTitles = DataBase.getInstance().getAllTagTitles();
        m_tagsListModel.fireContentChanged();
        
        if(bt != null) {
            for(BookTitle item : m_bookTitles) {
                if(item.getId().equals(bt.getId())) {
                    m_booksList.setSelectedValue(item, true);
                    break;
                }
            }
        }
        else {
            m_booksList.setSelectedIndex(0);
        }
        
        if(ft != null) {
            for(FormatTitle item : m_formatTitles) {
                if(item.getId().equals(ft.getId())) {
                    m_formatsList.setSelectedValue(item, true);
                    break;
                }
            }
        }
        else {
            m_formatsList.setSelectedIndex(0);
        }
        
        if(tt != null) {
            for(TagTitle item : m_tagTitles) {
                if(item.getId().equals(tt.getId())) {
                    m_tagsList.setSelectedValue(item, true);
                    break;
                }
            }
        }
        else {
            m_tagsList.setSelectedIndex(0);
        }

        m_booksCountLabel.setText("Всего: " + m_bookTitles.size());

        return;
    }

    private void viewTag() {
        admintool.entity.TagTitle tagTitle;
    
        tagTitle = (admintool.entity.TagTitle) m_tagsList.getSelectedValue();

        setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
    
        if(tagTitle != null) {
            m_tagPane.setData(DataBase.getInstance().getTag(tagTitle.getId()));
        }
        else {
            m_tagPane.setData(null);
        }
    
        setCursor(java.awt.Cursor.getDefaultCursor());
    
        return;
    }
    
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if(b) {
            refreshData();
        }
    }
    
    private java.util.List<admintool.entity.BookTitle> m_bookTitles;
    private java.util.List<admintool.entity.FormatTitle> m_formatTitles;
    private java.util.List<admintool.entity.TagTitle> m_tagTitles;
    
    private class BooksListModel extends javax.swing.AbstractListModel {
        BooksListModel() {
        }
        
        public void fireContentChanged() {
            super.fireContentsChanged(this, 0, MainFrame.this.m_bookTitles.size());
        }
        
        public int getSize() {
            if(MainFrame.this.m_bookTitles == null) {
                return 0;
            }
            return MainFrame.this.m_bookTitles.size();
        }

        public Object getElementAt(int index) {
            if(MainFrame.this.m_bookTitles == null) {
                return null;
            }
            return MainFrame.this.m_bookTitles.get(index);
        }
    }
    
    private class FormatsListModel extends javax.swing.AbstractListModel {
        FormatsListModel() {
        }
        
        public void fireContentChanged() {
            super.fireContentsChanged(this, 0, MainFrame.this.m_formatTitles.size());
        }
        
        public int getSize() {
            if(MainFrame.this.m_formatTitles == null) {
                return 0;
            }
            return MainFrame.this.m_formatTitles.size();
        }

        public Object getElementAt(int index) {
            if(MainFrame.this.m_formatTitles == null) {
                return null;
            }
            return MainFrame.this.m_formatTitles.get(index);
        }
    }
    
    private class TagsListModel extends javax.swing.AbstractListModel {
        TagsListModel() {
        }
        
        public void fireContentChanged() {
            super.fireContentsChanged(this, 0, MainFrame.this.m_tagTitles.size());
        }
        
        public int getSize() {
            if(MainFrame.this.m_tagTitles == null) {
                return 0;
            }
            return MainFrame.this.m_tagTitles.size();
        }

        public Object getElementAt(int index) {
            if(MainFrame.this.m_tagTitles == null) {
                return null;
            }
            return MainFrame.this.m_tagTitles.get(index);
        }
    }
    
    private BooksListModel m_booksListModel;
    private FormatsListModel m_formatsListModel;
    private TagsListModel m_tagsListModel;
    private AddBookDialog m_addBookDialog;
    private AddFormatDialog m_addFormatDialog;
    private AddTagDialog m_addTagDialog;
}
