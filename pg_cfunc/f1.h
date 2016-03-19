#pragma once

/*
 * Если этот C-файл будет использоваться C++ компилятором - пусть он использует C-нотацию для функций
 */
#ifdef __cplusplus
extern "C" {
#endif /* __cplusplus */

/**
 * C-функция, переворачивающая строку.
 * На выходе - новая строка, выделенная malloc()-ом. После использования - делать free() обязательно.
 */
char * f1(const char * str);

#ifdef __cplusplus
} /* extern "C" */
#endif /* __cplusplus */
