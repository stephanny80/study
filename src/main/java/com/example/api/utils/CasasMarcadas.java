package com.example.api.utils;

public class CasasMarcadas {
/*
			String [] R = new String[4];
			R[0] = "...X.";
			R[1] = ".X..X";
			R[2] = "X...X";
			R[3] = "..X..";
			solution(R);
*/

    public int solution(String[] R) {
        int qtdLinha = R.length;
        int qtdColuna = R[0].length();

        if (qtdLinha == 1 && qtdColuna == 1) return 1;

        int[][] casasMarcadas = new int[qtdColuna][qtdColuna];
        int sentido = 0; //0 direita 1 baixo 2 esquerda 3 cima e depois volta para o 0
        int linha = 0;
        int coluna = 0;
        int qtdCasas = 0;

        //iniciando o codigo novamente (IDE codility bem dificil)
        while (true) {
            //Marcando as casas
            if (casasMarcadas[linha][coluna] == 0) {
                casasMarcadas[linha][coluna] = 1;
                qtdCasas++;
            }

            int proximaLinha = linha;
            int proximaColuna = coluna;

            //navegação
            switch (sentido) {
                case 0:  //direita
                    proximaColuna++;
                    break;
                case 1: //baixo
                    proximaLinha++;
                    break;
                case 2: //esquerda
                    proximaColuna--;
                    break;
                case 3: //cima
                    proximaLinha--;
                    break;
            }

            //verificar proximo
            //escrevendo teste mesa no intellij

            if (proximaLinha < 0 || proximaLinha >= qtdLinha || proximaColuna < 0 || proximaColuna >= qtdColuna || R[proximaLinha].charAt(proximaColuna) == 'X') {
                sentido++;
                if (sentido > 3) sentido = 0;
            } else {
                linha = proximaLinha;
                coluna = proximaColuna;
            }

            //proxima casa
            if (linha == 0 && coluna == 0 && sentido == 0) {
                return qtdCasas;
            }

            //interceção
            if (!verificaIntercecao(sentido, R, casasMarcadas, linha, coluna)) {
                return qtdCasas;
            }

        }
    }

    private boolean verificaIntercecao(int sentido, String[] R, int[][] casasMarcadas, int linha, int coluna) {
        if (casasMarcadas[linha][coluna] == 0) return true;

        int qtdLinha = R.length;
        int qtdColuna = R[0].length();

        switch (sentido) {
            case 0: //direita
                coluna++;
                if (R[linha].charAt(coluna) == '.' && casasMarcadas[linha][coluna] == 1) {
                    if (coluna + 1 > qtdColuna) return true;
                    return R[linha].charAt(coluna + 1) == '.';
                }
                return (casasMarcadas[linha][coluna] == 0);
            case 1: //baixo
                linha++;
                if (R[linha].charAt(coluna) == '.' && casasMarcadas[linha][coluna] == 1) {
                    if (linha + 1 > qtdLinha) return true;
                    //return R[linha+1].charAt(coluna) == '.';
                    return (casasMarcadas[linha][coluna] == 0);
                }
                return (casasMarcadas[linha][coluna] == 0);
            case 2: //esquerda
                coluna--;
                if (coluna < 0) return true;
                if (R[linha].charAt(coluna) == '.' && casasMarcadas[linha][coluna] == 1) {
                    if (coluna == 0) return true;
                    return R[linha].charAt(coluna - 1) == '.';
                }
                return (casasMarcadas[linha][coluna] == 0);
            case 3: //cima
                linha--;
                if (linha < 0) return true;
                if (R[linha].charAt(coluna) == '.' && casasMarcadas[linha][coluna] == 1) {
                    if (linha == 0) return true;
                    return R[linha - 1].charAt(coluna) == '.';
                }
                return (casasMarcadas[linha][coluna] == 0);
        }
        return true;
    }

}
