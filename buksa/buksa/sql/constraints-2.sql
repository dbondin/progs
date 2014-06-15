--
-- Helper function for getting book size
--
CREATE OR REPLACE FUNCTION bindata_size_fn(_id INTEGER)
  RETURNS INTEGER
  LANGUAGE 'plpgsql'
  AS
  $$
  DECLARE
   SEEK_END INTEGER DEFAULT 2;
   INV_READ INTEGER DEFAULT 262144; -- 0x00040000;
   loid OID;
   lo INTEGER;
   size INTEGER;
   status INTEGER;
  BEGIN
   -- Get LO OID
   SELECT bindata INTO loid FROM public.book WHERE id = $1;
   IF loid IS NULL
   THEN
    RETURN NULL;
   END IF;

   -- Open LO Descriptor
   lo := lo_open(loid, INV_READ);
   IF lo IS NULL
   THEN
    RETURN NULL;
   END IF;

   status := lo_lseek(lo, 0, SEEK_END);
   size := lo_tell(lo);
   status := lo_close(lo);

   RETURN size;
  END;
  $$;

CREATE OR REPLACE FUNCTION book_insert_update_trigger_fn()
  RETURNS TRIGGER
  LANGUAGE 'plpgsql'
  AS
  $$
  BEGIN

    -- Compute cover image size
    IF NEW.cover_image IS NULL
    THEN
      NEW.cover_image_size := NULL;
    ELSE
      NEW.cover_image_size := octet_length(NEW.cover_image);
    END IF;

    -- Compute binary data size
    IF NEW.bindata IS NULL
    THEN
      NEW.bindata_size := NULL;
    ELSE
      NEW.bindata_size := bindata_size_fn(NEW.id);
    END IF;

    RETURN NEW;

  END;
  $$;

CREATE TRIGGER book_insert_update_trigger
  BEFORE INSERT OR UPDATE
  ON book FOR EACH ROW
  EXECUTE PROCEDURE book_insert_update_trigger_fn();
