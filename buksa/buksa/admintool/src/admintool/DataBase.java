package admintool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.hibernate.Transaction;

public class DataBase {

    public static final String USER_PROPERTIES_FILE_NAME = ".admintool.properties";

    public static final String [] USER_PROPERTIES_BASIC_NAMES = {
        "hibernate.connection.url",
        "hibernate.connection.username",
        "hibernate.connection.password"
    };
    
    public static DataBase getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DataBase();
        }
        return DataBase.INSTANCE;
    }

    public class BookInfoAndFormatTitles {
        public admintool.entity.BookInfo bookInfo;
        java.util.List<admintool.entity.FormatTitle> formatTitles;
        java.util.List<admintool.entity.TagTitle> tagTitles;
    }
    
    public class BookInfoAndFormat {
        public admintool.entity.BookInfo bookInfo;
        public admintool.entity.Format format;
    }
    
    public boolean hasConnection() {
        
        Transaction t;

        try {
            t = m_sessionFactory.getCurrentSession().beginTransaction();
            t.rollback();
        }
        catch(Exception ex) {
            return false;
        }

        return true;
    }

    public BookInfoAndFormat getBookInfoAndFormat(Long bookId) {
        BookInfoAndFormat result;
        org.hibernate.Session s;
        
        if(bookId == null) {
            return null;
        }
        
        result = new BookInfoAndFormat();
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        
        result.bookInfo = (admintool.entity.BookInfo) s.get(admintool.entity.BookInfo.class, bookId);
        
        if(result.bookInfo != null) {
            if(result.bookInfo.getFormat() != null) {
                result.format = (admintool.entity.Format) s.get(admintool.entity.Format.class, result.bookInfo.getFormat().getId());
            }
        }
        else {
            result = null;
        }
        
        s.getTransaction().commit();
        
        return result;
    }
    
    public admintool.entity.BookInfo getBookInfo(Long bookId) {
        admintool.entity.BookInfo bi;
        org.hibernate.Session s;
        
        if(bookId == null) {
            return null;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        
        bi = (admintool.entity.BookInfo) s.get(admintool.entity.BookInfo.class, bookId);
        
        s.getTransaction().commit();
        
        return bi;
    }
    
    public boolean deleteBook(Long bookId) {
        org.hibernate.Session s;
        admintool.entity.BookTitle bt;
        
        if(bookId == null) {
            return false;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();

        bt = (admintool.entity.BookTitle) s.get(admintool.entity.BookTitle.class, bookId);
        s.delete(bt);
        
        s.getTransaction().commit();
        
        return true;
    }
    
    public boolean deleteFormat(Long formatId) {
        org.hibernate.Session s;
        admintool.entity.FormatTitle ft;
        
        if(formatId == null) {
            return false;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();

        ft = (admintool.entity.FormatTitle) s.get(admintool.entity.FormatTitle.class, formatId);
        
        if(ft == null) {
            s.getTransaction().rollback();
            return false;
        }
        
        s.delete(ft);
        
        s.getTransaction().commit();
        
        return true;
    }
    
    public boolean deleteTag(Long tagId) {
        org.hibernate.Session s;
        admintool.entity.TagTitle tt;
        
        if(tagId == null) {
            return false;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();

        tt = (admintool.entity.TagTitle) s.get(admintool.entity.TagTitle.class, tagId);
        
        if(tt == null) {
            s.getTransaction().rollback();
            return false;
        }
        
        s.delete(tt);
        
        s.getTransaction().commit();
        
        return true;
    }
    
    public java.sql.Blob createBlob(java.io.InputStream is) {
        java.sql.Blob result;
        try {
            result = org.hibernate.Hibernate.createBlob(is);
        } catch(java.io.IOException ex) {
            result = null;
        }
        
        return result;
    }
    
    public boolean addBook(admintool.entity.Book book) {
        org.hibernate.Session s;
        
        if(book == null) {
            return false;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();

        s.save(book);
        
        s.getTransaction().commit();

        return true;
    }
    
    public boolean addFormat(admintool.entity.Format format) {
        org.hibernate.Session s;
        
        if(format == null) {
            return false;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();

        s.save(format);
        
        s.getTransaction().commit();

        return true;
    }
    
    public boolean addTag(admintool.entity.Tag tag) {
        org.hibernate.Session s;
        
        if(tag == null) {
            return false;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();

        s.save(tag);
        
        s.getTransaction().commit();

        return true;
    }
    
    public BookInfoAndFormatTitles getBookInfoAndFormatTitles(Long bookId) {
        BookInfoAndFormatTitles result;
        org.hibernate.Session s;
        
        if(bookId == null) {
            return null;
        }
        
        result = new BookInfoAndFormatTitles();
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        
        result.formatTitles = s.createQuery("from FormatTitle order by title").list();
        result.tagTitles = s.createQuery("from TagTitle order by title").list();
        result.bookInfo = (admintool.entity.BookInfo) s.get(admintool.entity.BookInfo.class, bookId);
        
        s.getTransaction().commit();
        
        if(result.bookInfo == null) {
            return null;
        }
        
        return result;
    }
    
    public admintool.entity.Format getFormat(Long formatId) {
        admintool.entity.Format f;
        org.hibernate.Session s;
        
        if(formatId == null) {
            return null;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        
        f = (admintool.entity.Format) s.get(admintool.entity.Format.class, formatId);
        
        s.getTransaction().commit();
        
        return f;
    }
           
    public admintool.entity.Tag getTag(Long tagId) {
        admintool.entity.Tag t;
        org.hibernate.Session s;
        
        if(tagId == null) {
            return null;
        }
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        
        t = (admintool.entity.Tag) s.get(admintool.entity.Tag.class, tagId);
        
        s.getTransaction().commit();
        
        return t;
    }
    
    public java.util.List<admintool.entity.BookTitle> getAllBookTitles() {
        java.util.List<admintool.entity.BookTitle> result;
        org.hibernate.Session s;
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        result = s.createQuery("from BookTitle order by title").list();
        s.getTransaction().commit();
        return result;
    }
    
    public java.util.List<admintool.entity.FormatTitle> getAllFormatTitles() {
        java.util.List<admintool.entity.FormatTitle> result;
        org.hibernate.Session s;
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        result = s.createQuery("from FormatTitle order by title").list();
        s.getTransaction().commit();
        return result;
        
    }
    
    public java.util.List<admintool.entity.TagTitle> getAllTagTitles() {
        java.util.List<admintool.entity.TagTitle> result;
        org.hibernate.Session s;
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        result = s.createQuery("from TagTitle order by title").list();
        s.getTransaction().commit();
        return result;      
    }
    
    public void updateBookInfo(admintool.entity.BookInfo bookInfo) {
        org.hibernate.Session s;
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        s.update(bookInfo);
        s.getTransaction().commit();
        
        return;
    }
    
    public void updateFormat(admintool.entity.Format format) {
        org.hibernate.Session s;
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        s.update(format);
        s.getTransaction().commit();
        
        return;
    }
    
    public void updateTag(admintool.entity.Tag tag) {
        org.hibernate.Session s;
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        s.update(tag);
        s.getTransaction().commit();
        
        return;
    }
    
    public boolean saveBookDataStream(Long bookId, java.io.OutputStream os) {
        org.hibernate.Session s;
        admintool.entity.Book b;
        java.io.InputStream is;
        byte [] buffer;
        int read;
        boolean result;
        
        buffer = new byte[1024];
        result = true;
        
        s = m_sessionFactory.getCurrentSession();
        s.beginTransaction();
        b = (admintool.entity.Book) s.get(admintool.entity.Book.class, bookId);
        if(b != null && b.getBinData() != null) {
            try {
                is = b.getBinData().getBinaryStream();
                while(true) {
                    read = is.read(buffer);

                    if(read == -1) {
                        break;
                    }
                    os.write(buffer, 0, read);
                }
            } catch (java.sql.SQLException ex) {
                result = false;
            } catch (java.io.IOException ex) {
                result = false;
            }
        }
        else {
            result = false;
        }
        
        s.getTransaction().commit();
        
        return result;
    }
    
    private DataBase() {

        org.hibernate.cfg.Configuration hcfg;
        org.hibernate.cfg.AnnotationConfiguration hac;
        Properties userProperties;
        FileInputStream userPropertiesFileInputStream;
        String userHome;
        String userPropertiesFileName;

        hac = new org.hibernate.cfg.AnnotationConfiguration();
        
        hac.addAnnotatedClass(admintool.entity.BookTitle.class);
        hac.addAnnotatedClass(admintool.entity.BookInfo.class);
        hac.addAnnotatedClass(admintool.entity.Book.class);
        hac.addAnnotatedClass(admintool.entity.FormatTitle.class);
        hac.addAnnotatedClass(admintool.entity.Format.class);
        hac.addAnnotatedClass(admintool.entity.TagTitle.class);
        hac.addAnnotatedClass(admintool.entity.Tag.class);

        hcfg = hac.configure();

        userProperties = new Properties();

        userHome = System.getProperty("user.home");

        if(userHome != null) {
            userPropertiesFileName = userHome + java.io.File.separator + USER_PROPERTIES_FILE_NAME;

            try {
                userPropertiesFileInputStream = new FileInputStream(userPropertiesFileName);

                userProperties.load(userPropertiesFileInputStream);
            }
            catch(Exception ex) {
                /* Something went wrong. Greate default properties file this */

                Properties newUserProperties = new Properties();

                for(String name : USER_PROPERTIES_BASIC_NAMES) {
                    newUserProperties.setProperty(name, hcfg.getProperty(name));
                }

                try {
                    newUserProperties.store(new FileOutputStream(userPropertiesFileName), "Buksa Admintool properties file");
                }
                catch(Exception e) {
                    /* Can't save the properties. Ignore */
                }
            }
        }

        for(String name : USER_PROPERTIES_BASIC_NAMES) {
            if(userProperties.containsKey(name)) {
                hcfg.setProperty(name, userProperties.getProperty(name));
            }
        }
        
        m_sessionFactory = hcfg.buildSessionFactory();

        return;
    }

    private static DataBase INSTANCE = null;
    
    private org.hibernate.SessionFactory m_sessionFactory;    
}
