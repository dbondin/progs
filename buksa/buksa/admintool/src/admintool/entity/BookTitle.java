package admintool.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity()
@Table(name="book", schema="public")
@SequenceGenerator(name="BOOK_SEQ", sequenceName="public.book_id_seq")
public class BookTitle extends BookTitleColumns {
    public BookTitle() {
        super();
    }
    public BookTitle(BookTitle bt) {
        super(bt);
    }
}
