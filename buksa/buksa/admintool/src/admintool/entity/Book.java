package admintool.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="book", schema="public")
@SequenceGenerator(name="BOOK_SEQ", sequenceName="public.book_id_seq")
public class Book extends BookColumns {
    public Book() {
        return;
    }
    public Book(BookInfo bi) {
        super(bi);
        return;
    }
    public Book(BookTitle bt) {
        super(bt);
        return;
    }
    public Book(Book b) {
        super(b);
        return;
    }
}
