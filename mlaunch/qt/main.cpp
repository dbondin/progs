#include<string.h>
#include<stdio.h>
#include<unistd.h>
#include<qapplication.h>
#include<qfiledialog.h>
#include<qmessagebox.h>

#include "common.h"

int main(int argc, char **argv)
{
  QApplication app( argc, argv );
  QString qfname;
  QFileDialog qfdialog;
  char cfname[NAME_MAX + 1];

  qfdialog.setCaption(MLAUNCH_DEF_TITLE);
  qfdialog.setDir(MLAUNCH_DEF_DIR);
  qfdialog.setMode(QFileDialog::ExistingFile);
  qfdialog.setViewMode(QFileDialog::Detail);
  qfdialog.setModal(true);
  qfdialog.showMaximized();
  if(qfdialog.exec() == QDialog::Rejected)
  {
    /* No file selected */
    return 1;
  }

  qfname = qfdialog.selectedFile();

  //qfname = QFileDialog::getOpenFileName("/mnt/maxtor/Films",
  //                                      "",
  //                                      NULL,
  //                                      "open file dialog",
  //                                      "XINE Launcher" );

  if(qfname == QString::null)
  {
    /* No file selected */
    return 1;
  }

  sprintf(cfname, "%s", (const char *) qfname.local8Bit());

  run(argc, argv, (char *) cfname);

  QMessageBox::critical(NULL,
                        "Error",
                        "Can't find player executable");

  return 0;
}
