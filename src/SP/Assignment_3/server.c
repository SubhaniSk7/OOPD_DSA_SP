#include <stdio.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <time.h>
#include <pthread.h>

#define PORT 5555
void *chat(void *);

int clients = 1;
int main(int argc, char *argv[]) {
	int listenfd = 0, connfd = 0;
	struct sockaddr_in serv_addr;

	char sendBuff[1024];

	listenfd = socket(AF_INET, SOCK_STREAM, 0);
	memset(&serv_addr, '0', sizeof(serv_addr));
	memset(sendBuff, '0', sizeof(sendBuff));

	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
	serv_addr.sin_port = htons(PORT);

	bind(listenfd, (struct sockaddr*) &serv_addr, sizeof(serv_addr));
	listen(listenfd, 5);
	pthread_t tid[5];
	int lc = 0;
	printf("Server is Active...\n");

	while (connfd = accept(listenfd, (struct sockaddr*) NULL, NULL)) {

		printf("\nAccepted a connection\n");

		pthread_create(&tid[lc++], NULL, chat, (void *) &connfd);
		//pthread_exit(NULL);
		listen(listenfd, 5);
	}
}

void *chat(void *arg) {

	int clientCount = clients++;
	printf("Connected to client %d\n", clientCount);
	int connfd = *(int *) arg;
	char request[1024], response[1024];
	int bt;

	while (1) {

		bt = recv(connfd, request, 1024, 0);
		request[bt] = 0;

		if (strcmp(request, "exit\n") == 0) {
			send(connfd, "exit", 4, 0);
			clients--;
			close(connfd);
			pthread_exit(0);
		}

		printf("Client %d request:%s\n", clientCount, request);
		int l = strlen(request);

		fgets(response, 1024, stdin);
		response[strlen(response)] = 0;
		send(connfd, response, strlen(response), 0);
	}
	return NULL;

}
