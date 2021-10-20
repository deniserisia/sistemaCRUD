#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
   int n, aux, primo = 1;

   printf("\n Digite um numero inteiro:");
   scanf("%d", &n);

   for(aux = 2; primo && (aux <= sqrt(n)); aux++)
   //Pega o resto da divisão
    if ((n % aux)== 0)
        primo = 0;

   if(primo)
    printf("\n Numero primo!");
   else
    printf("\n Numero composto!");

    return 0;
}
