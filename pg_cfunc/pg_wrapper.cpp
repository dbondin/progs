/*
 *  Все, что касается PostgreSQL оборачиваем в extern "C" { ... } здесь и далее в этом файле.
 */
extern "C" {
#include <postgres.h>
#include <fmgr.h>
} /* extern "C" */

/* C-строки */
#include <cstring>
/* C++-строки */
#include <string>

#include "f1.h"
#include "f2.h"

extern "C" {
#ifdef PG_MODULE_MAGIC
PG_MODULE_MAGIC;
#endif
} /* extern "C" */

extern "C" {
PG_FUNCTION_INFO_V1(pg_func_f1);
PG_FUNCTION_INFO_V1(pg_func_f2);
} /* extern "C" */

/**
 * Это будет вызываемая из SQL функция вида:
 *
 * pg_func_f1(text) returns text
 *
 * Она будет дергать C-функцию f1()
 */
extern "C" {
Datum pg_func_f1(PG_FUNCTION_ARGS) {

	/* elog() - просто логгируем все, что нам интересно */
	elog(INFO, "pg_func_f1() started2");

	/* Берем аргумент функции как TEXT */
	text * arg0 = PG_GETARG_TEXT_P(0);
	/* Запоминаем, сколько он весит. Это размер реальных данных + размер заголовка */
	uint32 arg0_size = VARSIZE(arg0);
	elog(INFO, "arg0_size = %u", arg0_size);

	/* Для простоты использования запоминаем указатель на данные как unsigned char */
	unsigned char * data = (unsigned char *) (VARDATA(arg0));
	/* Просто логгируем данные (с 0 до (arg0_size - VARHDRSZ) - т.е. минус размер заголовка, он нам не интересен) */
	for(uint32 i=0; i<arg0_size - VARHDRSZ; i++) {
		elog(INFO, "arg0 data[%3u] = 0x%2x (%3u) '%c'", i, data[i], data[i], ((data[i]>=32&&data[i]<128)?data[i]:'?'));
	}

	/* Для f1() нам нужна честная C-строка завершающаяся нулем - выделяем под нее память */
	char * c_str_in = (char *) palloc(arg0_size - VARHDRSZ + 1);
	/* Копируем данные */
	memcpy(c_str_in, data, arg0_size - VARHDRSZ);
	/* Ну и обнуляем послендий байт */
	c_str_in[arg0_size - VARHDRSZ] = 0;
	elog(INFO, "c_str_in = '%s'", c_str_in);

	/* Вызываем f1() */
	char * c_str_out = f1(c_str_in);
	elog(INFO, "c_str_out = '%s'", c_str_out);
	/* Запоминаем длинну результата */
	size_t c_str_out_size = strlen(c_str_out);

	/* Возращать назад в postgres надо TEXT, а не C-строку. Выделим под него память - длинна строки + заголовок */
	text * result = (text *) palloc(c_str_out_size + VARHDRSZ);
	/* Выставим полную длинну в стректуре TEXT */
	SET_VARSIZE(result, c_str_out_size + VARHDRSZ);
	/* Скопируем строковые данные из C-строки в TEXT */
	memcpy((void *) VARDATA(result), (void *) c_str_out, c_str_out_size);

	/* С-строка с результатом нам больше не нужна - освободим память (так устроена f1()) */
	free(c_str_out);

	elog(INFO, "pg_func_f1() finished");

	/* Ну и возвращаем результат */
	PG_RETURN_TEXT_P(result);
}
} /* extern "C" */

/**
 * Это будет вызываемая из SQL функция вида:
 *
 * pg_func_f2(text) returns text
 *
 * Она будет дергать C++-функцию f2()
 *
 * Она практически аналогична pg_func_f1(), только чуть проще работа с памятью -
 * не надо заморачиваться на выделение-освобождение - поэтому без комментариев
 */
extern "C" {
Datum pg_func_f2(PG_FUNCTION_ARGS) {

	text * arg0 = PG_GETARG_TEXT_P(0);

	std::string str_in(VARDATA(arg0), VARSIZE(arg0) - VARHDRSZ);
	std::string str_out = f2(str_in);

	text * result = (text *) palloc(str_out.length() + VARHDRSZ);
	SET_VARSIZE(result, str_out.length() + VARHDRSZ);
	memcpy((void *) VARDATA(result), (void *) str_out.data(), str_out.length());

	PG_RETURN_TEXT_P(result);
}
} /* extern "C" */
