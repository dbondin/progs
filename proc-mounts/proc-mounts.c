#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/time.h>
#include <unistd.h>


#define SCAN_BUFF_SIZE 1024

void scan(int fd) {
    char buff [SCAN_BUFF_SIZE];
    int rs = 0;

    lseek(fd, SEEK_SET, 0);
    while(1) {
        rs = read(fd, (void *) buff, SCAN_BUFF_SIZE);
        if(rs <= 0) {
            break;
        }
        write(1, (void *) buff, rs);
    }
}

int main(int argc, char ** argv) {

    int fd;
    fd_set rfds;
    struct timeval tv;
    int ret;

    fd = open("/proc/mounts", O_RDONLY);

    if(fd == -1) {
        fprintf(stderr, "Error opening /proc/mounts file for reading\n");
        return 1;
    }

    printf("fd=%d\n", fd);

    while(1) {
        while(1) {

            FD_ZERO(&rfds);
            FD_SET(fd, &rfds);
            tv.tv_sec = 0;
            tv.tv_usec = 0;

            ret = select(fd + 1, &rfds, NULL, NULL, &tv);

            if(ret == -1) {
                fprintf(stderr, "Error in select()\n");
                close(fd);
                return 2;
            }
            else if(ret == 0) {
                printf("No data\n");
            }
            else {
                printf("NEW DATA !!!\n");
                break;
            }

            sleep(1);
        }
        scan(fd);
    }

    close(fd);

    return 0;
}
