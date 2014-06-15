package admintool.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tag", schema="public")
@SequenceGenerator(name="TAG_SEQ", sequenceName="public.tag_id_seq")
public class TagTitle extends TagTitleColumns {
    public TagTitle() {
        super();
        return;
    }
}
