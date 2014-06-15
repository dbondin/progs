#include <stdlib.h>
#include <stdio.h>
#include <gtk/gtk.h>

void finish()
{
  exit(0);
}

void on_ok()
{
}

int main(int argc, char ** argv)
{
  GtkWidget * gfdialog;

  gtk_init(&argc, &argv);

  gfdialog = gtk_file_selection_new("Media Launcher");

  gtk_file_selection_set_filename(GTK_FILE_SELECTION(gfdialog),
                                  "/mnt/maxtor/Films/");
  gtk_file_selection_hide_fileop_buttons(GTK_FILE_SELECTION(gfdialog));
  gtk_file_selection_set_select_multiple(GTK_FILE_SELECTION(gfdialog),
                                         FALSE);

  g_signal_connect(GTK_FILE_SELECTION(gfdialog)->ok_button,
                   "clicked",
                   G_CALLBACK(on_ok),
                   NULL);

  g_signal_connect(GTK_FILE_SELECTION(gfdialog)->cancel_button,
                   "clicked",
                   G_CALLBACK(finish),
                   NULL);

  g_signal_connect(G_OBJECT(gfdialog),
                   "delete_event",
                   G_CALLBACK(finish),
                   NULL);

  gtk_widget_show(gfdialog);

  gtk_window_maximize(GTK_WINDOW(gfdialog));

  gtk_main();

  return 0;
}
