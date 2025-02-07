public class Main {
    public static void main(String[] args) {
        int[] identificadores =  new int[4];
        identificadores[0] = 88;
        identificadores[1] = 37;
        identificadores[2] = 22;

        int[] divisor =  new int[4];
        divisor[0] = 88;
        divisor[1] = 37;
        divisor[2] = 0;

        System.out.println("Imprimiento arreglo de "+identificadores.length+" elementos");
        for (int i = 0; i < identificadores.length + 1; i++) {
            try{
                System.out.println(identificadores[i] +"/"+ divisor[i] +" = " + identificadores[i] / divisor[i]);
            }catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("No existe el elemento");
            }catch(ArithmeticException e) {
                System.out.println("El divisor no puede ser cero");
            }catch(RuntimeException e) {
                System.out.println("Ocurrio un error irrecuperable");
            }finally {
                System.out.println("Operación concluida");
            }
        }
        System.out.println("Programa terminado");

    }
}