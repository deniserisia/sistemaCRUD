#include <stdio.h>
#include <stdlib.h>
// Primeiro exercicio de PPA - by: DRC
int main()
{
    // Declaramos variaveis certas para calcular todo tipo,com o menor tipo de erro possivel
    unsigned short int n, i;
    double fatorial = 1;

    //Uusario entrara com o numero interio
    printf("\n Digite um numero inteiro:");
    scanf("%hu", &n);

    //Usaremos o for pra um laço de repetição para resolver a questão
    for (i =1; i <= n ; i++)
        fatorial = fatorial * i;

    printf("%hu! = %.0f\n", n, fatorial);

    return 0;
}
