//	SUBHANI SHAIK
//	MT18117


#include <stdio.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 5555

int main(int argc, char *argv[]) {
    int listenfd = 0, connfd = 0;
    struct sockaddr_in serv_addr;



    listenfd = socket(AF_INET, SOCK_STREAM, 0);
    memset(&serv_addr, '0', sizeof (serv_addr));




    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(PORT);

    bind(listenfd, (struct sockaddr*) &serv_addr, sizeof (serv_addr));

    listen(listenfd, 5);
    printf("\nServer listening for connections!\n");

    connfd = accept(listenfd, (struct sockaddr*) NULL, NULL);
    printf("\nAccepted a connection\n");

	char request[1024]; //to store client request message
	memset(request, '0', sizeof(request));

	char response[1024]; // to send reverse string
	memset(response, '0', sizeof(response));

	if (recv(connfd, request, strlen(request), 0) < 0) { // receiving the client request message, if not successful then print Not Received
        printf("Not Received");
	} else { // successfully received the request message
        printf("Received : %s", request);

		int length = 0, i, j;
		while (request[length] != '\0') //finding length of the client request
			length++;
		j = length - 1;

		for (i = 0; i < length; i++) { // reversing the client string and copying it to response buffer
			response[i] = request[j];
			j--;
		}
		response[i] = '\0';

		printf("Reverse string to send:%s", response); // printing the reversed string
    }

	if (send(connfd, response, sizeof(response), 0) < 0) // sending the response, if not successful then print Error
        printf("Send Error\n");
	else
		//sent successfully
		printf("\nSent successful\n");

    close(connfd);

}
