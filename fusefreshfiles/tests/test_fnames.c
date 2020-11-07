#include <limits.h>
#include <assert.h>

#include "../fnames.h"

int main(int argc, char const *argv[])
{
    int status;
    char out[NAME_MAX + 1];
    status = fnames_rtov("filename.txt", out, NAME_MAX, 123);
    assert(status == 0);
    
    return 0;
}
