package admintool.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class TagTitleColumns {
    public TagTitleColumns() {
        return;
    }
    
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "TAG_SEQ", strategy=GenerationType.SEQUENCE)
    public Long getId() {
        return m_id;
    }

    public void setId(Long id) {
        m_id = id;
        return;
    }

    @Column(name="title", nullable=false, length=64)
    public String getTitle() {
        return m_title;
    }

    public void setTitle(String title) {
        m_title = title;
        return;
    }

    @Override
    public String toString() {
        return m_title;
    }
    
    private Long   m_id;
    private String m_title;
}
