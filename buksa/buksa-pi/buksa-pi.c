#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<libpq-fe.h>

#define REQUIRED_ARGC 8
#define CONNINFO_MAX_LEN 1024

#define FILE_PREFIX ""
#define FILE_POSTFIX ".jpg"

const char ESC_CHARS[] = {'\'', '\\'};

/* **************************************************** *\
 * Local function prototypes
\* **************************************************** */
static void
print_usage();

static char *
escape_string(const char * s);

static PGconn *
connect(const char * dbhost,
        const int dbport,
        const char * dbname,
        const char * dbuser,
        const char * dbpass);

static void
disconnect(PGconn * conn);

static int
process_pages(PGconn * conn,
              const char * imgdir,
              long book_id);

static char *
get_file_name(const char * imgdir,
              int page);

/* **************************************************** *\
 * main()
\* **************************************************** */
int
main(int argc, char ** argv) {

  PGconn * conn = NULL;

  if(REQUIRED_ARGC != argc) {
    print_usage();
    return 1;
  }

  conn = connect(argv[1], /* dbhost */
                 atoi(argv[2]), /*dbport*/
                 argv[3], /* dbname */
                 argv[4], /* dbuser */
                 argv[5]); /* dbpass */

  if(NULL == conn) {
    fprintf(stderr, "ERROR:\nError conecting to database\n");
    return 2;
  }

  if(PQstatus(conn) != CONNECTION_OK) {
    fprintf(stderr, "ERROR:\n%s\n", PQerrorMessage(conn));
    disconnect(conn);
    return 3;
  }

  process_pages(conn, argv[6], atol(argv[7]));

  disconnect(conn);

  return 0;
}

void
print_usage() {

  fprintf(stderr, "Usage: buksa-pi <dbhost> <dbport> <dbname> <dbuser> <dbpass> <imgdir> <book_id>\n");

  return;
}

char *
escape_string(const char * s) {

  int i;
  int j;
  int s_len = 0;
  int es_len = 0;
  char * es = NULL;

  if(NULL != s) {
    s_len = strlen(s);
  }

  es_len = s_len + 1; /* original len + 1 for \0 */

  for(i=0; i<s_len; i++) {
    for(j=0; j<sizeof(ESC_CHARS)/sizeof(ESC_CHARS[0]); j++) {
      if(ESC_CHARS[j] == s[i]) {
        es_len ++; /* add one char for every escaped char */
        break;
      }
    }
  }

  es = (char *) malloc(sizeof(char) * es_len);

  es_len = 0;

  for(i=0; i<s_len; i++) {
    for(j=0; j<sizeof(ESC_CHARS)/sizeof(ESC_CHARS[0]); j++) {
      if(ESC_CHARS[j] == s[i]) {
        es[es_len] = '\\';
        es_len ++;
        break;
      }
    }
    es[es_len] = s[i];
    es_len ++;
  }

  es[es_len] = 0; /* terminating \0 */

  return es;
}

PGconn *
connect(const char * dbhost,
        const int dbport,
        const char * dbname,
        const char * dbuser,
        const char * dbpass) {

  char conninfo [CONNINFO_MAX_LEN];

  char * esc_dbhost = escape_string(dbhost);
  char * esc_dbname = escape_string(dbname);
  char * esc_dbuser = escape_string(dbuser);
  char * esc_dbpass = escape_string(dbpass);

  snprintf(conninfo,
           CONNINFO_MAX_LEN - 1,
           "host='%s' port='%d' dbname='%s' user='%s' password='%s'",
           esc_dbhost,
           dbport,
           esc_dbname,
           esc_dbuser,
           esc_dbpass);

  free(esc_dbhost);
  free(esc_dbname);
  free(esc_dbuser);
  free(esc_dbpass);

  return PQconnectdb(conninfo);
}

void
disconnect(PGconn * conn) {

  PQfinish(conn);

  return;
}

int
process_pages(PGconn * conn,
              const char * imgdir,
              long book_id) {

  int pages;
  FILE * file;

  

  pages = 0;

  while(1) {

    file = fopen(get_file_name(imgdir, pages + 1), "r");

    if(NULL == file) {
      break;
    }

    pages ++;
  }

  return 0;
}

static char *
get_file_name(const char * imgdir,
              int page) {

  static char FILE_NAME[NAME_MAX + 1];

  sprintf(FILE_NAME,
          "%s/%s%d%s",
          imgdir,
          FILE_PREFIX,
          page,
          FILE_POSTFIX);

  return FILE_NAME;
}
