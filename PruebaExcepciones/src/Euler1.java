public class Euler1 {
    public static void main(String[] args) {

        int multiplo1 = 3;
        int multiplo2 = 5;

        int numeroMaxino = 999;
        int resultado = 0;
        int [] multiplosEncontrados = new int [numeroMaxino];
        int [] universo = new int [numeroMaxino];

        for (int i = 0; i < universo.length; i++) {
            universo[i] = i+1;
        }

        for (int i = 0; i < universo.length; i++) {
            System.out.println(universo[i]);
            if (universo[i] % multiplo1 == 0 || universo[i] % multiplo2 == 0) {
                multiplosEncontrados[i] = universo[i];
                resultado += multiplosEncontrados[i];
            }
        }

        System.out.println("Resultado = "+resultado);
    }
}
