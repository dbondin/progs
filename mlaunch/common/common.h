#ifndef __MLAUNCH_COMMON__
#define __MLAUNCH_COMMON__

#ifdef __cplusplus
#define EXPORT extern "C"
#else /* __cplusplus */
#define EXPORT extern
#endif /* __cplusplus */

/* Default program to run */
#define MLAUNCH_DEF_PROG "/usr/bin/xine"

/* Default selection dialog title */
#define MLAUNCH_DEF_TITLE "Media Launcher"

/* Default directory to open */
#define MLAUNCH_DEF_DIR "/mnt/maxtor/Films/"

/* Exec program. Returns on error. Not returns on success */
EXPORT void run(int argc, char ** argv, const char * filename);

#endif /* __MLAUNCH_COMMON__ */
