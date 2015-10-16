#include <iostream>
#include <string>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/ip.h>

using namespace std;

class socket_guard {
public:
	socket_guard(int s) : _s(s) {};
	virtual ~socket_guard() {
		close(_s);
	}
private:
	int _s;
};

void http_server() {
	int sock = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	socket_guard sg(sock);
	if(sock == -1) {
		perror("1");
		return;
	}
	//setsockopt(sock, SO_REUSEADDR, 1);
	struct sockaddr_in my_addr;
	my_addr.sin_addr.s_addr = 0;
	my_addr.sin_port = htons(8080);
	my_addr.sin_family = AF_INET;
	int status = bind(sock, (struct sockaddr *)&my_addr, sizeof(my_addr));
	if(status == -1) {
		perror("2");
		return;
	}
	status = listen(sock, 5);
	if(status == -1) {
		perror("3");
		return;
	}
	int csock = accept(sock, NULL, NULL);
	if(csock == -1) {
		perror("3");
		return;
	}
	cout<<"csock="<<csock<<endl;
	char buffer[1024 + 1];
	read(csock, buffer, 1024);
	string message = "<html><body><h1>Hello!!!</h1></body></html>";
	string data = "200 HTTP/1.1\nContent-Type: text/html\nContent-Length: ";
	data += "42";
	data += "\n\n";
	data += message;
	write(csock, data.c_str(), data.length());
	close(csock);
}

int main(int argc, char **argv) {
	http_server();
	return 0;
}

