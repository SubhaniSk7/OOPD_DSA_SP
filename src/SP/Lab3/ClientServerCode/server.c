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
#include <string.h>

#define PORT 5555

int main(int argc, char *argv[])
{
    int listenfd = 0, connfd = 0,readbytes;
    struct sockaddr_in serv_addr; 

    char sendBuff[500];
    
    //
    char recBuffer[1024];
    //
    
    listenfd = socket(AF_INET, SOCK_STREAM, 0);
    memset(&serv_addr, '0', sizeof(serv_addr)); 
    memset(sendBuff, '0', sizeof(sendBuff)); 

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(PORT); 

    bind(listenfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr)); 

    listen(listenfd, 5); 
    printf("\nServer listening for connections!\n");
    
    time_t t_seconds;

    while(1)
    {
        connfd = accept(listenfd, (struct sockaddr*)NULL, NULL); 
        printf("\nAccepted a connection\n");
        t_seconds = time(0);

		
        snprintf(sendBuff, sizeof(sendBuff), "%s\n", ctime(&t_seconds));
        write(connfd, sendBuff, strlen(sendBuff)); 


	//
		memset(recBuffer, '0',sizeof(recBuffer));
		int valread=0;
		//valread = read( listenfd , recBuffer, 1024);
		while ( (readbytes=read(listenfd, recBuffer, sizeof(recBuffer))) > 0)
		{
			recBuffer[readbytes] = 0;
			printf("%s",recBuffer);
		}
		if(readbytes < 0)
		{
			printf("\n Read error \n");
		}
		
		printf("client string:%s\n",recBuffer );
		
		int length=0,i,j;
		while (recBuffer[length] != '\0')
			length++;
	   
		j = length - 1;
		for (i = 0; i < length; i++) {
		  sendBuff[i] = recBuffer[j];
		  j--;
		}
		sendBuff[i] = '\0';
	 
		printf("%s\n", sendBuff);
		
		//write(connfd, sendBuff, strlen(sendBuff)); 
		send(connfd , sendBuff , strlen(sendBuff) , 0 );
		printf("Hello message sent\n");  
    //
        close(connfd);
        
     }
}
