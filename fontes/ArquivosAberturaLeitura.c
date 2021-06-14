/* 
 * Arquivo: ArquivosAberturaLeitura.c
 * Autor: Prof. Dr. David Buzatto
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

    // declaração de um ponteiro para arquivo
    FILE *arquivo;
    char dadosLinha[80];
    int inteiro;
    float decimal;

    /* abrindo o arquivo "arquivoDados.txt", que está no mesmo diretório
     * do programa no modo somente leitura.
     *
     * Os modos de abertura para leitura e escrita de dados de texto são:
     *     - "r"  -> Abre para leitura (read), o arquivo precisa existir.
     *     - "w"  -> Abre para escrita (write), o arquivo não
     *               precisa existir.
     *     - "a"  -> Abre para anexação (append), o arquivo não
     *               precisa existir.
     *     - "r+" -> Abre para leitura e escrita, começando do
     *               início do arquivo.
     *     - "w+" -> Abre para leitura e escrita, sobrescrevendo os dados
     *               do arquivo caso exista.
     *     - "a+" -> Abre para leitura e escrita, anexando os dados no
     *               arquivo caso exista.
     */
    arquivo = fopen( "arquivoDados.txt", "r" );

    /* adicionalmente, caso se deseje ler ou escrever dados binários
     * em arquivos, os modos são, respetivamente:
     * "rb", "wb", "ab",
     * "r+b" ou "rb+",
     * "w+b" ou "wb+" e
     * "a+b" ou "ab+".
     */

    // verificando se o arquivo foi aberto
    if ( arquivo != NULL ) {  // aberto

        // lê uma linha do arquivo três vezes e a imprime
        for ( int i = 0; i < 3; i++ ) {
            fgets( dadosLinha, 80, arquivo );
            dadosLinha[strlen(dadosLinha)-1] = '\0';
            printf( "Linha lida: \"%s\"\n", dadosLinha );
        }

        // lê um inteiro do arquivo
        fscanf( arquivo, "%d", &inteiro );
        printf( "Inteiro lido: %d\n", inteiro );

        // mais uma linha!
        fgetc( arquivo ); // descarta o pulo de linha
                          // que sobrou do fscanf!
        fgets( dadosLinha, 80, arquivo );
        dadosLinha[strlen(dadosLinha)-1] = '\0';
        printf( "Linha lida: \"%s\"\n", dadosLinha );

        // lê um float do arquivo
        fscanf( arquivo, "%f", &decimal );
        printf( "Decimal lido: %.2f\n", decimal );

        /* uma forma de verificar se o fim do arquivo foi
         * alcançado é utilizar a função feof (file
         * end of file). Essa função retorna 0 (falso) caso
         * o fim do arquivo ainda não foi encontrado ou
         * um valor diferente de zero (verdadeiro) caso contrário.
         */
        printf( "Fim do arquivo? %s\n", feof(arquivo) ? "sim" : "nao" );

        // mais uma linha!
        fgetc( arquivo );
        fgets( dadosLinha, 80, arquivo );
        dadosLinha[strlen(dadosLinha)-1] = '\0';
        printf( "Linha lida: \"%s\"\n", dadosLinha );

        /* nesse ponto, devido aos dados do arquivo, não há
         * mais dados para serem lidos!
         */
        printf( "Fim do arquivo? %s\n", feof(arquivo) ? "sim" : "nao" );

    } else { // erro ao abrir
        printf( "O arquivo nao pode ser aberto!" );
    }

    // fechando o arquivo (SEMPRE FECHE O(S) ARQUIVO(S) ABERTO(S)!!!)
    fclose( arquivo );

    return 0;

}
