package admintool.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="format", schema="public")
@SequenceGenerator(name="FORMAT_SEQ", sequenceName="public.format_id_seq")
public class Format extends FormatColumns {
    public Format() {
        return;
    }
}
