#include <stdio.h>
#include <string.h>
#include <mongoose.h>

static void *callback(enum mg_event event,
                      struct mg_connection *conn,
                      const struct mg_request_info *request_info) {

  if (event == MG_NEW_REQUEST) {
    char content[1024];
    int content_length = snprintf(content, sizeof(content),
                                  "Hello from mongoose!\n"
                                  "Remote port: %d\n"
                                  "Request method: %s\n"
                                  "URI: %s\n",
                                  request_info->remote_port,
                                  request_info->request_method,
                                  request_info->uri);
    mg_printf(conn,
              "HTTP/1.1 200 OK\r\n"
              "Content-Type: text/plain\r\n"
              "Content-Length: %d\r\n"
              "\r\n"
              "%s",
              content_length, content);
    // Mark as processed
    return "";
  } else {
    return NULL;
  }
}

int main(void) {
  struct mg_context *ctx;
  const char *options[] = {"listening_ports", "8080", NULL};

  ctx = mg_start(&callback, NULL, options);
  getchar(); // Wait until user hits "enter"
  mg_stop(ctx);

  return 0;
}
