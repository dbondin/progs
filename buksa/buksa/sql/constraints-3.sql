ALTER TABLE public.preview_page ADD CONSTRAINT preview_id_and_pageno_uniq
UNIQUE(id, pageno);

CREATE VIEW public.v_book_preview AS
SELECT b.id AS id,
       b.title AS title,
       b.authors AS authors,
       p.pages_num AS pages_num,
       (p.pages_num IS NOT NULL)::BOOLEAN as has_preview
FROM public.book b LEFT JOIN
     public.preview p ON (b.id = p.id);
