package admintool.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class FormatColumns extends FormatTitleColumns {
    public FormatColumns() {
        setCTime(java.util.Calendar.getInstance().getTime());
        setMTime(java.util.Calendar.getInstance().getTime());
        return;
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

    @Column(name="description", nullable=true, length=256)
    public String getDescription() {
        return m_description;
    }

    public void setDescription(String description) {
        m_description = description;
    }
    
    @Column(name="extension", nullable=true, length=16)
    public String getExtension() {
        return m_extension;
    }

    public void setExtension(String extension) {
        m_extension = extension;
    }
    
    @Column(name="mime_type", nullable=true, length=64)
    public String getMimeType() {
        return m_mimeType;
    }

    public void setMimeType(String mimeType) {
        m_mimeType = mimeType;
    }

    private String m_description;
    private String m_extension;
    private String m_mimeType;
    private java.util.Date m_cTime;
    private java.util.Date m_mTime;
}
