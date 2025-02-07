import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AlgoritmoArreglos {

    public static void main(String[] args) {

            try{
                System.out.println("Leyendo contenido archivo: primero.txt");
                String[] contenido1 = leerArchivo("C:\\projects\\archivos_ejercicio\\primero.txt");
                for (int i = 0; i < contenido1.length; i++) {
                    System.out.print(contenido1[i]+" ");
                }
                System.out.println("");

                System.out.println("Leyendo contenido archivo: segundo.txt");
                String[] contenido2 = leerArchivo("C:\\projects\\archivos_ejercicio\\segundo.txt");
                for (int i = 0; i < contenido2.length; i++) {
                    System.out.print(contenido2[i]+" ");
                }
                System.out.println("");

                double numero1 = convertirNumero(contenido1);
                double numero2 = convertirNumero(contenido2);

                System.out.printf("El resultado es: (%f + %f = %f)", numero1, numero2, (numero1 + numero2));
            }catch(IOException error){
                System.out.println("Error al cerrar el archivo");
            }
    }

    private static String[] leerArchivo(String archivo) throws IOException {
        String [] contenido = new String[1000];
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int contador = 0;
           do{
               linea = br.readLine();
               if(linea != null){
                   contador++;
                   contenido[contador] = linea;
               }
            } while(linea != null);
            br.close();
        }catch(FileNotFoundException errorArchivoNoEncontrado){
            System.out.println("No se encontro el archivo");
        }catch (IOException errorArchivoCorrupto){
            System.out.println("Error al leer el archivo");
        }

        return limpiarArreglo(contenido);

    }

    private static String [] limpiarArreglo(String [] valores){
        String [] valores2 = new String[valores.length];
        int contador = 0;
        for(int i = 0; i < valores.length; i++){
            if(valores[i] != null){
                valores2[contador] = valores[i];
                contador++;
            }
        }
        String [] valoresResultado = new String[contador];
        for(int i = 0; i < contador; i++){
            valoresResultado[i] = valores2[i];
        }
        return valoresResultado;
    }

    private static double convertirNumero(String [] valores){
        double numero = 0;
        // v*10^i = n
        try{
            for (int i = 0; i < valores.length; i++) {
                numero += Integer.parseInt(valores[i]) * Math.pow(10, i);
            }
        }catch(NumberFormatException error){
            System.out.println("Error al convertir el numero. Error: " + error.getMessage());
        }

        return numero;
    }
}
