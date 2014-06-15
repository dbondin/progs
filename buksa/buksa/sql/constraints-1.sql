-- This is constraints file for model.architect ERD model
-- Target platform is PostgreSQL

-- Change datatype for book.bindata
ALTER TABLE book DROP COLUMN bindata;
ALTER TABLE book ADD COLUMN bindata OID NOT NULL;

-- Add 'unique' constraint to tag.title
ALTER TABLE tag ADD UNIQUE (title);

--
-- Trigger function for keep ctime/mtime fields in valid state.
--
-- REQ: Trigger must be BEFORE INSERT or BEFORE UPDATE.
-- REQ: Trigger must be FOR EACH ROW.
-- REQ: Table MUST contain ctime and mtime columns with
--      TIMESTAMP type.
--
CREATE OR REPLACE FUNCTION ctime_mtime_trigger_fn()
  RETURNS TRIGGER
  LANGUAGE 'plpgsql'
  AS
  $$
  BEGIN

    NEW.mtime = current_timestamp;

    IF TG_OP = 'INSERT'
    THEN
      NEW.ctime = NEW.mtime;
    END IF;

    IF TG_OP = 'UPDATE'
    THEN
      NEW.ctime = OLD.ctime;
    END IF;

    RETURN NEW;

  END;
  $$;

CREATE TRIGGER book_ctime_mtime_trigger
  BEFORE INSERT OR UPDATE
  ON book FOR EACH ROW
  EXECUTE PROCEDURE ctime_mtime_trigger_fn();

CREATE TRIGGER tag_ctime_mtime_trigger
  BEFORE INSERT OR UPDATE
  ON tag FOR EACH ROW
  EXECUTE PROCEDURE ctime_mtime_trigger_fn();

CREATE TRIGGER format_ctime_mtime_trigger
  BEFORE INSERT OR UPDATE
  ON format FOR EACH ROW
  EXECUTE PROCEDURE ctime_mtime_trigger_fn();

--

CREATE OR REPLACE FUNCTION book_bindata_update_trigger_fn()
  RETURNS TRIGGER
  LANGUAGE 'plpgsql'
  AS
  $$
  BEGIN
    NEW.bindata = OLD.bindata;
    RETURN NEW;
  END;
  $$;


CREATE TRIGGER book_bindata_update_trigger
  BEFORE UPDATE
  ON book FOR EACH ROW
  EXECUTE PROCEDURE book_bindata_update_trigger_fn();

CREATE OR REPLACE FUNCTION book_bindata_delete_trigger_fn()
  RETURNS TRIGGER
  LANGUAGE 'plpgsql'
  AS
  $$
  BEGIN
    PERFORM lo_unlink(OLD.bindata);
    RETURN OLD;
  END;
  $$;

CREATE TRIGGER book_bindata_delete_trigger
  AFTER DELETE
  ON book FOR EACH ROW
  EXECUTE PROCEDURE book_bindata_delete_trigger_fn();

--
-- Trigger function for insert tags
--
CREATE OR REPLACE FUNCTION tag_insert_update_trigger_fn()
  RETURNS TRIGGER
  LANGUAGE 'plpgsql'
  AS
  $$
  BEGIN

    -- Make the title lowercase and trim spaces
    NEW.title = trim(both ' ' from lower(NEW.title));

    RETURN NEW;

  END;
  $$;

CREATE TRIGGER tag_insert_update_trigger
  BEFORE INSERT OR UPDATE
  ON tag FOR EACH ROW
  EXECUTE PROCEDURE tag_insert_update_trigger_fn();

--
-- Helper function for getting book size
--
CREATE OR REPLACE FUNCTION book_size_fn(_id INTEGER)
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
