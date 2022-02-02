#include<stdio.h>
#include<unistd.h>

int main(){
    printf("PRUEBA DE PROCESOS:");

    fork();

    printf("Se ha creado un proceso ");
    return 1;
}
