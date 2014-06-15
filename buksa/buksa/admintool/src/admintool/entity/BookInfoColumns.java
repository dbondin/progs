package admintool.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.Type;

@MappedSuperclass
public class BookInfoColumns extends BookTitleColumns {
    
    public BookInfoColumns() {
        setCTime(java.util.Calendar.getInstance().getTime());
        setMTime(java.util.Calendar.getInstance().getTime());
        return;
    }
    public BookInfoColumns(BookTitleColumns btc) {
        super(btc);
        setCTime(java.util.Calendar.getInstance().getTime());
        setMTime(java.util.Calendar.getInstance().getTime());
        return;
    }
    public BookInfoColumns(BookInfoColumns bic) {
        super(bic);
        setAuthors(bic.getAuthors());
        setCTime(bic.getCTime());
        setCoverImageData(bic.getCoverImageData());
        setDescription(bic.getDescription());
        setFilename(bic.getFilename());
        setFormat(bic.getFormat());
        setMTime(bic.getMTime());
        setPublisher(bic.getPublisher());
        setYear(bic.getYear());
        setTags(bic.getTags());
        return;
    }
    
    @Column(name="authors", nullable=true, length=128)
    public String getAuthors() {
        return m_authors;
    }

    public void setAuthors(String authors) {
        m_authors = authors;
    }

    @Column(name="description", nullable=true, length=256)
    public String getDescription() {
        return m_description;
    }

    public void setDescription(String description) {
        m_description = description;
    }

    @Column(name="publisher", nullable=true, length=128)
    public String getPublisher() {
        return m_publisher;
    }

    public void setPublisher(String publisher) {
        m_publisher = publisher;
    }

    @Column(name="year", nullable=true)
    public Integer getYear() {
        return m_year;
    }

    public void setYear(Integer year) {
        m_year = year;
    }

    @Column(name="filename", nullable=false, length=256)
    public String getFilename() {
        return m_filename;
    }

    public void setFilename(String filename) {
        m_filename = filename;
    }

    @Column(name="ctime", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getCTime() {
        return m_cTime;
    }

    public void setCTime(java.util.Date cTime) {
        m_cTime = cTime;
    }

    @Column(name="mtime", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getMTime() {
        return m_mTime;
    }

    public void setMTime(java.util.Date mTime) {
        m_mTime = mTime;
    }

    @Column(name="cover_image")
    @Lob
    @Type(type="binary")
    public byte [] getCoverImageData() {
        return m_coverImageData;
    }
    
    public void setCoverImageData(byte [] coverImageData) {
        m_coverImageData = coverImageData;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="format_id")
    public FormatTitle getFormat() {
        return m_format;
    }
    
    public void setFormat(FormatTitle format) {
        m_format = format;
    }
    
    @Override
    public String toString() {
        return getTitle();
    }
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="book_tag",
               joinColumns={@JoinColumn(name="book_id")},
               inverseJoinColumns={@JoinColumn(name="tag_id")})
    public java.util.Collection<admintool.entity.TagTitle> getTags() {
        return m_tags;
    }
    
    public void setTags(java.util.Collection<admintool.entity.TagTitle> tags) {
        m_tags = tags;
    }
    
    /* Table columns */
    private String         m_filename;
    private java.util.Date m_cTime;
    private java.util.Date m_mTime;
    private byte []        m_coverImageData;
    private String         m_authors;
    private String         m_publisher;
    private String         m_description;
    private Integer        m_year;
    private FormatTitle    m_format;
    private java.util.Collection<admintool.entity.TagTitle> m_tags;
}
