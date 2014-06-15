#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <string.h>
#include <errno.h>

#define LOOPS 1000
#define BUFFER_SIZE ( 1024 * 1024 )
#define FILE_NAME "file.dat"

struct timeval TV;
double START_TIME = 0.0;
double END_TIME = 0.0;
void * mmptr = NULL;

#define TV_START() { gettimeofday(&TV, NULL); START_TIME = 1000000.0 * TV.tv_sec + 1.0 * TV.tv_usec; };
#define TV_END() { gettimeofday(&TV, NULL); END_TIME = 1000000.0 * TV.tv_sec + 1.0 * TV.tv_usec; };
#define TV_PRINT(message) { printf("%s %.2f %.2f %.2f\n", message, START_TIME / 1000000.0, END_TIME / 1000000.0, (END_TIME - START_TIME) / 1000000.0); };

int main(int argc, char ** argv) {

  int i;
  FILE * f;
  int fd;
  unsigned char buffer[BUFFER_SIZE];

  /* Initialize buffer */
  srand(time(NULL));
  for(i=0; i<LOOPS; i++) {
    buffer[i] = (unsigned char)(rand() & 0xff);
  }

  /* [1] fwrite(1, N) */
  TV_START();
  for(i=0; i<LOOPS; i++) {
    f = fopen(FILE_NAME, "w");
    if(f == NULL) {
      fprintf(stderr, "Error opening file for write\n");
      return 1;
    }

    fwrite(buffer, 1, BUFFER_SIZE, f);

    fclose(f);
  }
  TV_END();
  TV_PRINT("fwrite(1, N)");

  /* [2] fwrite(N, 1) */
  TV_START();
  for(i=0; i<LOOPS; i++) {
    f = fopen(FILE_NAME, "w");
    if(f == NULL) {
      fprintf(stderr, "Error opening file for write\n");
      return 1;
    }

    fwrite(buffer, BUFFER_SIZE, 1, f);

    fclose(f);
  }
  TV_END();
  TV_PRINT("fwrite(N, 1)");

  /* [3] mmap() */
  TV_START();
  for(i=0; i<LOOPS; i++) {
    fd = open(FILE_NAME, O_RDWR, 0644);
    if(fd == -1) {
      fprintf(stderr, "Error opening file for write\n");
      return 1;
    }

    mmptr = mmap(NULL, BUFFER_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

    if(mmptr == MAP_FAILED) {
      close(fd);
      fprintf(stderr, "Error mmap %s\n", strerror(errno));
      return 2;
    }

    memcpy(mmptr, buffer, BUFFER_SIZE);

    munmap(mmptr, BUFFER_SIZE);
    close(fd);
  }
  TV_END();
  TV_PRINT("mmap()");

  return 0;
}
