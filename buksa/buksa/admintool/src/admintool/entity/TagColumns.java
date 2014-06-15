package admintool.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class TagColumns extends TagTitleColumns {
    public TagColumns() {
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

    private java.util.Date m_cTime;
    private java.util.Date m_mTime;
}
