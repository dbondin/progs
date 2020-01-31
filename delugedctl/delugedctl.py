#!/usr/bin/env python

import os
import web

web.config.debug = True

render = web.template.render("templates/")

urls = (
    "/", "index",
    '/favicon.ico', 'icon'
)

def is_deluged_running():
    res = os.system("ps -C deluged")
    return True if (res == 0) else False

def start_deluged():
    os.system("/usr/bin/deluged -L info -l /var/log/deluge/deluged.log && sleep 1")

def stop_deluged():
    os.system("killall deluged && sleep 1")

class index:
    def GET(self):
        i=web.input(action=None)
        deluged_running=is_deluged_running()
        if i.action is not None:
            if i.action == "start" and deluged_running == False:
                start_deluged()
            elif i.action == "stop" and deluged_running == True:
                stop_deluged()
        deluged_running=is_deluged_running()
        return render.index(deluged_running)

class icon:
    def GET(self): raise web.seeother("/static/favicon.ico")
    
if __name__ == "__main__":
    app = web.application(urls, globals())
    app.run()
