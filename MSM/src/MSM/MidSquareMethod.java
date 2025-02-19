package MSM;

public class MidSquareMethod {

    // Função para contar o número de dígitos de um número
    public static int contarDigitos(long chave) {
        int contagem = 0;
        while (chave != 0) {
            chave /= 10;
            contagem++;
        }
        return contagem;
    }

    // Função para pegar o número central do quadrado de um número
    public static int obterNumeroCentral(long numero) {
        int comprimento = contarDigitos(numero);
        int posicaoMeio = comprimento / 2; // Posição central do número

        // Definir a quantidade de dígitos centrais a serem extraídos
        int numDigitosCentrais = (comprimento > 4) ? 3 : (comprimento % 2 == 0 ? 2 : 1); // 3 dígitos se 5 ou mais, 2 ou 1 se 4 ou menos
        int inicio = posicaoMeio - (numDigitosCentrais / 2); // Posição inicial

        // Calculando o número central
        int resultado = 0;
        for (int i = 0; i < numDigitosCentrais; i++) {
            // Pegando o dígito da posição calculada
            resultado = resultado * 10 + (int) (numero / Math.pow(10, (comprimento - inicio - 1))) % 10;
            inicio++;
        }

        return resultado;
    }

    // Função de hashing usando o método do quadrado do meio
    public static int hashingQuadradoDoMeio(int chave) {
        long quadradoChave = (long) chave * chave; // Quadrado da chave

        // Pegando o número central do quadrado da chave
        int valorHash = obterNumeroCentral(quadradoChave);

        return valorHash;
    }

    public static void main(String[] args) {
        int chave = 82; // Exemplo de chave
        int indiceHash = hashingQuadradoDoMeio(chave);
        System.out.println("Índice de hash gerado: " + indiceHash); 
}

