package admintool.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="book", schema="public")
@SequenceGenerator(name="BOOK_SEQ", sequenceName="public.book_id_seq")
public class BookInfo extends BookInfoColumns {
    public BookInfo() {
        return;
    }
    public BookInfo(BookTitle bt) {
        super(bt);
    }
    public BookInfo(BookInfo bi) {
        super(bi);
        return;
    }
}
