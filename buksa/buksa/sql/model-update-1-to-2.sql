-- Convert model from [1] to [2]

ALTER TABLE public.book ADD COLUMN bindata_size INTEGER;
ALTER TABLE public.book ADD COLUMN cover_image_size INTEGER;
