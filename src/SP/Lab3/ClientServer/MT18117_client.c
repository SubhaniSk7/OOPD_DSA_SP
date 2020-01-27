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
	int sock = 0;
	struct sockaddr_in serv_addr;

    if (argc != 2) {
		printf("\n Usage: %s <Server IP address>\n", argv[0]);
		return -1;
	}


    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
		printf("\n Socket creation error \n");
		return -1;
	}

	memset(&serv_addr, '0', sizeof(serv_addr));

    serv_addr.sin_family = AF_INET;
	serv_addr.sin_port = htons(PORT);

    if (inet_pton(AF_INET, argv[1], &serv_addr.sin_addr) <= 0) //convert IPv4 and IPv6 addresses from text to binary form
			{
		printf("\nInvalid address/ Address not supported \n");
		return -1;
	}

	if (connect(sock, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0) {
		printf("\nConnection Failed \n");
		return -1;
	}

	char request[1024]; // // to send request string
	memset(request, '0', sizeof(request));

	char response[1024];
	memset(response, '0', sizeof(response));

	printf("Enter request message to reverse: ");
	fgets(request, 1024, stdin); // taking input string from user

	if (send(sock, request, sizeof(request), 0) < 0) // sending the request messsage to server, if not successful then print Error
		printf("Send Error\n");
	else
		//successfully sent
		printf("Sent successful\n");

	if (recv(sock, request, strlen(request), 0) < 0) // receiving the reversed string, if not successful then print Not Received
		printf("Not Received.\n");
	else
		// successfully received the request message
		printf("Received : %s\n", request);

	close(sock);

    return 0;
}
