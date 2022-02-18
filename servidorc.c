#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include<netinet/in.h>
#include <string.h>


int main (int argc, char **argv){
	int fd, fd2, longitud_cliente, puerto; 
	puerto= atoi(argv[1]); 

	struct sockaddr_in server; 
	struct sockaddr_in client; 
	server.sin_family = AF_INET; 
	server.sin_port =htons (puerto); 
server.sin_addr.s_addr = INADDR_ANY; 
bzero(&(server.sin_zero), 8); 
if((fd=socket(AF_INET, SOCK_STREAM, 0))<0){
	perror("Error en la apertura del socket"); 
	exit(-1); 
}
if(bind(fd, (struct sockaddr*)&server, sizeof (struct sockaddr))==-1){
	printf("Error en bind()\n"); 
	exit(-1); 
}
if(listen(fd, 5)==-1){
	printf("Error en listen()\n"); 
	exit(-1); 
}
while(1){
	longitud_cliente =sizeof(struct sockaddr_in); 
	if((fd2 = accept (fd, (struct sockaddr*) &client, &longitud_cliente))==-1){
		printf("Error en accept ()\n"); 
		exit(-1); 
}
send(fd2, "Bienvenido a mi servidor \n", 26, 0); 
close (fd2); 
}
	close(fd); 
}
else {
	printf("No se ingreso el puerto por parametro \n"); 
}
return 0; 
}

