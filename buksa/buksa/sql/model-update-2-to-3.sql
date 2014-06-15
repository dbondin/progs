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
