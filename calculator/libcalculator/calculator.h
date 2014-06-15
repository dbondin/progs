#ifndef __CALCULATOR_H__
#define __CALCULATOR_H__

#ifdef __cplusplus
extern "C" {
#endif

/**
 * Calculates 'expr' as infix expresion.
 * On error returns non-null in 'status'.
 */
double calculator(const char * expr, int * status);

#ifdef __cplusplus
}
#endif

#endif /* __CALCULATOR_H__ */
