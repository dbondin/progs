package admintool.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@MappedSuperclass
public class BookColumns extends BookInfoColumns {
    
    public BookColumns() {
        return;
    }
    public BookColumns(BookTitleColumns btc) {
        super(btc);
        return;
    }
    public BookColumns(BookInfoColumns bic) {
        super(bic);
        return;
    }
    public BookColumns(BookColumns bc) {
        super(bc);
        setBinData(bc.getBinData());
        return;
    }
    
    @Column(name="bindata", nullable=false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    public java.sql.Blob getBinData() {
        return m_binData;
    }

    public void setBinData(java.sql.Blob binData) {
        m_binData = binData;
    }

    /* Table columns */
    private java.sql.Blob m_binData;
}
