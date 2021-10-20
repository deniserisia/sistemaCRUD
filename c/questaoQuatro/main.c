#include <stdio.h>
#include <conio.h>
#include <time.h>
#include <stdlib.h>

int main(){

    int i,j,x,y;
    int matriz[444][999];
    int soma = 0;

    printf("\n Digite a quantidade de linhas da sua matriz: ");
    scanf("%d",&x);
    printf("\n Digite a mesma quantidade de linhas para as colunas da matriz: ");
    scanf("%d",&y);

    for(i=0;i<x;i++)
        for(j=0;j<y;j++)
             scanf("%d",&matriz[i][j]);
    for(i=0;i<x;i++)
        for(j=0;j<y;j++)
            matriz[i][j] = 1000 + rand() % 1000;
            printf( "%3d", matriz[i][j] );
            if( i==j ){
                soma += matriz[i][j];
            }
        printf( "\n" );
        printf( "Soma da diagonal principal: %d", soma );

    getch();
    return 0;
}
