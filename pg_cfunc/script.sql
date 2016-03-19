create or replace function pg_func_f1(text)
	returns text
	language C
	as '/home/dbondin/progs/pg_cfunc/libpg_func.so', 'pg_func_f1';

create or replace function pg_func_f2(text)
	returns text
	language C
	as '/home/dbondin/progs/pg_cfunc/libpg_func.so', 'pg_func_f2';
