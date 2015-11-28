#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <limits.h>
#include <sys/inotify.h>

int main() {

  int inofd = inotify_init();
  int wd;
  void * buffer;
  ssize_t rs;

  if(inofd == -1) {
    perror("inotify_init()");
    return 1;
  }

  wd = inotify_add_watch(inofd, ".", IN_CREATE | IN_DELETE);

  if(wd == -1) {
    perror("inotify_add_watch()");
    return 1;
  }
  
  buffer = malloc(sizeof(struct inotify_event) + NAME_MAX + 1);

  while(1) {
    struct inotify_event * e;
    rs = read(inofd, buffer, sizeof(struct inotify_event) + NAME_MAX + 1);
    if(rs == -1) {
      perror("read()");
      break;
    }
    if(rs < sizeof(struct inotify_event)) {
      break;
    }
    e = (struct inotify_event *) buffer;
    if(e->mask & IN_CREATE) {
      printf("CREATE %s\n", e->name);
    }
    if(e->mask & IN_DELETE) {
      printf("DELETE %s\n", e->name);
    }
  }


  return 0;
}
