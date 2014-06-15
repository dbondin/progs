
CREATE SEQUENCE public.format_id_seq;

CREATE TABLE public.format (
                id INTEGER NOT NULL DEFAULT nextval('public.format_id_seq'),
                title VARCHAR(64) NOT NULL,
                description VARCHAR(256) NOT NULL,
                extension VARCHAR(16) NOT NULL,
                mime_type VARCHAR(64) NOT NULL,
                ctime TIMESTAMP NOT NULL,
                mtime TIMESTAMP NOT NULL,
                CONSTRAINT format_id PRIMARY KEY (id)
);


ALTER SEQUENCE public.format_id_seq OWNED BY public.format.id;

CREATE SEQUENCE public.tag_id_seq;

CREATE TABLE public.tag (
                id INTEGER NOT NULL DEFAULT nextval('public.tag_id_seq'),
                title VARCHAR(256) NOT NULL,
                ctime TIMESTAMP NOT NULL,
                mtime TIMESTAMP NOT NULL,
                CONSTRAINT tag_id PRIMARY KEY (id)
);


ALTER SEQUENCE public.tag_id_seq OWNED BY public.tag.id;

CREATE SEQUENCE public.book_id_seq;

CREATE TABLE public.book (
                id INTEGER NOT NULL DEFAULT nextval('public.book_id_seq'),
                title VARCHAR(256) NOT NULL,
                authors VARCHAR(128),
                publisher VARCHAR(128),
                year INTEGER,
                filename VARCHAR(256) NOT NULL,
                description VARCHAR(256),
                ctime TIMESTAMP NOT NULL,
                mtime TIMESTAMP NOT NULL,
                bindata BYTEA NOT NULL,
                cover_image BYTEA,
                format_id INTEGER,
                bindata_size INTEGER,
                cover_image_size INTEGER,
                CONSTRAINT book_id PRIMARY KEY (id)
);
COMMENT ON TABLE public.book IS 'Книга';
COMMENT ON COLUMN public.book.bindata_size IS 'trigger-evaluated field';
COMMENT ON COLUMN public.book.cover_image_size IS 'trigger-generated value';


ALTER SEQUENCE public.book_id_seq OWNED BY public.book.id;

CREATE TABLE public.preview (
                id INTEGER NOT NULL,
                pages_num INTEGER NOT NULL,
                CONSTRAINT preview_pk PRIMARY KEY (id)
);


CREATE SEQUENCE public.preview_page_id_seq;

CREATE TABLE public.preview_page (
                id INTEGER NOT NULL DEFAULT nextval('public.preview_page_id_seq'),
                pageno INTEGER NOT NULL,
                page_image BYTEA NOT NULL,
                preview_id INTEGER NOT NULL,
                CONSTRAINT preview_page_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.preview_page_id_seq OWNED BY public.preview_page.id;

CREATE TABLE public.book_tag (
                book_id INTEGER NOT NULL,
                tag_id INTEGER NOT NULL,
                CONSTRAINT book_tag_id PRIMARY KEY (book_id, tag_id)
);


ALTER TABLE public.book ADD CONSTRAINT format_book_relation
FOREIGN KEY (format_id)
REFERENCES public.format (id)
ON DELETE SET NULL
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.book_tag ADD CONSTRAINT tag_book_tag_relation
FOREIGN KEY (tag_id)
REFERENCES public.tag (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.book_tag ADD CONSTRAINT book_book_tag_relation
FOREIGN KEY (book_id)
REFERENCES public.book (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.preview ADD CONSTRAINT book_preview_fk
FOREIGN KEY (id)
REFERENCES public.book (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.preview_page ADD CONSTRAINT preview_preview_page_fk
FOREIGN KEY (preview_id)
REFERENCES public.preview (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;
