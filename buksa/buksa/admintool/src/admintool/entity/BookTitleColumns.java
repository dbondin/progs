package admintool.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GenerationType;

@MappedSuperclass()
public class BookTitleColumns {
    public BookTitleColumns() {
        return;
    }
    
    public BookTitleColumns(BookTitleColumns btc) {
        setId(btc.getId());
        setTitle(btc.getTitle());
        return;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "BOOK_SEQ", strategy=GenerationType.SEQUENCE )
    public Long getId() {
        return m_id;
    }

    public void setId(Long id) {
        m_id = id;
        return;
    }

    @Column(name="title", nullable=false, length=256)
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
